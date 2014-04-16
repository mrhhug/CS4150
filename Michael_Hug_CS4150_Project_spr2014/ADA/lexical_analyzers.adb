with Ada.Text_IO, Ada.Characters.Handling;
use Ada.Text_IO, Ada.Characters.Handling;

package body Lexical_Analyzers is


   function all_digits (s: in String; size: in Positive) return Boolean is

      i: Positive := 1;

   begin
      while i <= size and then is_digit (s(i)) loop
         i := i + 1;
      end loop;
      return i > size;
   end all_digits;

   ---------------------------------------------------------------------

   function is_white_space (ch: in Character) return Boolean is

   begin
      return ch = Character'Val (9) or ch = ' ';
   end is_white_space;

   ----------------------------------------------------------------------

   procedure skip_white_space (line: in String; index: in out Natural) is

   begin
      while index <= line'Length and then is_white_space (line (index)) loop
         index := index + 1;
      end loop;
   end skip_white_space;

   ------------------------------------------------------------------------

   function get_lexeme (line: in String; column_number: in Natural) return Lexeme is

      i: Positive := column_number;
      l: Lexeme;

   begin
      while i <= line'Length and then not is_white_space (line (i)) loop
          i := i + 1;
      end loop;
      l := to_lexeme (line (column_number .. i - 1));
      return l;
   end get_lexeme;

   -----------------------------------------------------------------------------

   function determine_token_type (l: in Lexeme; line_number: in Positive;
                                  column_number: in Positive) return Token_Type
   is
      tok_type: Token_Type;

   begin
      if is_letter (l(1)) then
         if size_of_lexeme (l) = 1 then
            tok_type := ID_TOK;
         elsif l = to_lexeme ("if") then
            tok_type := IF_TOK;
         elsif l = to_lexeme ("until") then
            tok_type := UNTIL_TOK;
         elsif l = to_lexeme ("then") then
            tok_type := THEN_TOK;
         elsif l = to_lexeme ("else") then
            tok_type := ELSE_TOK;
         elsif l = to_lexeme ("end") then
            tok_type := END_TOK;
         elsif l = to_lexeme ("puts") then
            tok_type := PUTS_TOK;
         elsif l = to_lexeme ("def") then
            tok_type := DEF_TOK;
         elsif l = to_lexeme ("while") then
            tok_type := WHILE_TOK;
         elsif l = to_lexeme ("do") then
            tok_type := DO_TOK;
         else
            raise lexical_exception with "invalid lexeme at row" &
              Positive'Image(line_number) & " and column " &
              Positive'Image (column_number);
         end if;
      elsif is_digit (l(1)) then
         if all_digits (String(l), size_of_lexeme (l)) then
            tok_type := LIT_INT;
         else
            raise lexical_exception with "invalid literal integer at row" &
              Positive'Image(line_number) & " and column " &
              Positive'Image (column_number);
         end if;
      elsif l = to_lexeme ("=") then
         tok_type := ASSIGN_OP;
      elsif l = to_lexeme ("+") then
         tok_type := ADD_TOK;
      elsif l = to_lexeme ("-") then
         tok_type := SUB_TOK;
      elsif l = to_lexeme ("*") then
         tok_type := MUL_TOK;
      elsif l = to_lexeme ("/") then
         tok_type := DIV_TOK;
      elsif l = to_lexeme ("==") then
         tok_type := EQ_TOK;
      elsif l = to_lexeme ("/=") then
         tok_type := NE_TOK;
      elsif l = to_lexeme ("<") then
         tok_type := LT_TOK;
      elsif l = to_lexeme ("<=") then
         tok_type := LE_TOK;
      elsif l = to_lexeme (">") then
         tok_type := GT_TOK;
      elsif l = to_lexeme (">=") then
         tok_type := GE_TOK;
      else
         raise lexical_exception with "invalid lexeme at row" &
           Positive'Image(line_number) & " and column " &
           Positive'Image (column_number);
      end if;
      return tok_type;
   end determine_token_type;

   -------------------------------------------------------------------------

   procedure process_line (lex: in out Lexical_Analyzer; line: in String;
                 line_number: in Positive) is

      column_number: Positive := 1;
      current: Lexeme;
      tok_type: Token_Type;
      tok: Token;

   begin
      skip_white_space (line, column_number);
      while column_number <= line'Length loop
         current := get_lexeme (line, column_number);
         tok_type := determine_token_type (current, line_number, column_number);
         tok := create_token (current, line_number, column_number, tok_type);
         Token_Lists.Append (lex.l, tok);
         column_number := column_number + size_of_lexeme (current);
         skip_white_space (line, column_number);
      end loop;
   end process_line;

   -----------------------------
   -- create_lexical_analyzer --
   -----------------------------

   function create_lexical_analyzer (file_name: in String)
                                     return Lexical_Analyzer is

      lex: Lexical_Analyzer;
      source_code: File_Type;
      line: String (1 .. 140);
      last: Natural;
      line_number: Positive := 1;

   begin
      open (source_code, In_file, file_name);
      while not end_of_file (source_code) loop
         get_line (source_code, line, last);
         process_line (lex, line (1 .. last), line_number);
         line_number := line_number + 1;
      end loop;
      Token_Lists.append (lex.l, create_token (to_lexeme("EOS"), line_number, 1,
                          EOS_TOK));
      close (source_code);
      return lex;
   end create_lexical_analyzer;

   -----------------
   -- more_tokens --
   -----------------

   function more_tokens (lex: in Lexical_Analyzer) return Boolean is
   begin
      return not Token_Lists.is_empty (lex.l);
   end more_tokens;

   --------------------
   -- get_next_token --
   --------------------

   procedure get_next_token (lex: in out Lexical_Analyzer;  tok: out Token) is

   begin
      tok := Token_Lists.First_Element (lex.l);
      Token_Lists.Delete_First (lex.l);
   end get_next_token;

   -------------------------
   -- get_lookahead_token --
   -------------------------

   function get_lookahead_token (lex: in Lexical_Analyzer) return Token is

   begin
      return Token_Lists.First_Element (lex.l);
   end get_lookahead_token;

end Lexical_Analyzers;
