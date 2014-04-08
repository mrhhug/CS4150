with tokentype;
use  tokentype;

package Tokens is

   type Token is private;

   MAX_LEXEME_LENGTH: constant Positive := 10;

   procedure create_Token (typ: in Token_type; lexeme: in String; columnNumber: in Positive; rowNumber: in Positive);

   function getTokenType (t: in Token) return Token_Type;

   function getColumnNumber (t: in Token) return Positive;

   function getRowNumber (t: in Token) return Positive;

   function getLexeme (t: in Token) return String;

private
   type Token is
      record
         rowNumber: Positive;
         columnNumber: Positive;
         lexeme: String(1 .. MAX_LEXEME_LENGTH) := (others => ' ');
         typ: Token_Type;
      end record;

end tokens;
