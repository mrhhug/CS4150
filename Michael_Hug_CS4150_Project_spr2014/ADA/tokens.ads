package Tokens is

   type Token_Type is (DEF_TOK, END_TOK, IF_TOK, PUTS_TOK, UNTIL_TOK, ID_TOK,
                       WHILE_TOK, ELSE_TOK, THEN_TOK, ASSIGN_OP, LIT_INT, ADD_TOK,
                       SUB_TOK, MUL_TOK, DIV_TOK, EQ_TOK, NE_TOK, LT_TOK, LE_TOK,
                       GT_TOK, GE_TOK, EOS_TOK, DO_TOK);

   LEXEME_SIZE: constant Positive := 10;

   type Lexeme is new String (1 .. LEXEME_SIZE);

   type Token is private;

   function create_token (lex: in Lexeme; row_number: in Positive;
                          column_number: in Positive; tok_type: in Token_Type)
                          return Token;

   function get_token_type (tok: in Token) return Token_Type;

   function get_lexeme (tok: in Token) return Lexeme;

   function get_row_number (tok: in Token) return Positive;

   function get_column_number(tok: in Token) return Positive;

   function to_lexeme (s: in String) return Lexeme;

   function size_of_lexeme (lex: in Lexeme) return Positive;

private
   type Token is
      record
         lex: Lexeme;
         row_number: Positive;
         column_number: Positive;
         tok_type: Token_type;
      end record;

end Tokens;
