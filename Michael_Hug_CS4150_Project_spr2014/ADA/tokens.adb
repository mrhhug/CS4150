with tokentype;
use  tokentype;

package body Tokens is

   ------------------
   -- create_Token --
   ------------------

   procedure create_Token
     (typ: in Token_Type;
      lexeme: in String;
      columnNumber: in Positive;
      rowNumber: in Positive)
   is
      tok:Token;

   begin
      if lexeme'Length <= MAX_LEXEME_LENGTH then
         tok.lexeme(1.. lexeme'Length) := lexeme;
      else
         tok.lexeme := lexeme (1 .. MAX_LEXEME_LENGTH);
      end if;
   end create_Token;

   ------------------
   -- getTokenType --
   ------------------

   function getTokenType (t: in Token) return Token_Type is
   begin
      return t.typ;
   end getTokenType;

   ---------------------
   -- getColumnNumber --
   ---------------------

   function getColumnNumber (t: in Token) return Positive is
   begin
     return t.columnNumber;
   end getColumnNumber;

   ------------------
   -- getRowNumber --
   ------------------

   function getRowNumber (t: in Token) return Positive is
   begin
      return t.rowNumber;
   end getRowNumber;

   ---------------
   -- getLexeme --
   ---------------

   function getLexeme (t: in Token) return String is
   begin
      return t.lexeme;
   end getLexeme;

end Tokens;
