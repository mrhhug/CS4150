package body Tokens is

   ------------------
   -- create_token --
   ------------------

   function create_token (lex: in Lexeme; row_number: in Positive;
                          column_number: in Positive;
                          tok_type: in Token_Type)
                          return Token is
      tok: Token;

   begin
      tok.lex := lex;
      tok.row_number := row_number;
      tok.column_number := column_number;
      tok.tok_type := tok_type;
      return tok;
   end create_token;

   --------------------
   -- get_token_type --
   --------------------

   function get_token_type (tok: in Token) return Token_Type is
   begin
      return tok.tok_type;
   end get_token_type;

   ----------------
   -- get_lexeme --
   ----------------

   function get_lexeme (tok: in Token) return Lexeme is
   begin
      return tok.lex;
   end get_lexeme;

   --------------------
   -- get_row_number --
   --------------------

   function get_row_number (tok: in Token) return Positive is
   begin
      return tok.row_number;
   end get_row_number;

   -----------------------
   -- get_column_number --
   -----------------------

   function get_column_number (tok: in Token) return Positive is
   begin
      return tok.column_number;
   end get_column_number;

   -------------------------------------------------------------------

   function to_lexeme (s: in String) return Lexeme is

      lex: Lexeme := (others => ' ');

   begin
      if s'Length > LEXEME_SIZE then
         for i in 1 .. LEXEME_SIZE loop
            lex (i) := s(i + s'First - 1);
         end loop;
      else
         for i in 1 .. s'Length loop
            lex(i) := s(i + s'First - 1);
         end loop;
      end if;
      return lex;
   end to_lexeme;

   ------------------------------------------------------------------------

   function size_of_lexeme (lex: in Lexeme) return Positive is

      size: Positive := 1;

   begin
      while lex(size) /= ' ' loop
         size := size + 1;
      end loop;
      return size - 1;
   end size_of_lexeme;

end Tokens;
