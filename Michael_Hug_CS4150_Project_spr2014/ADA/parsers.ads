with Lexical_Analyzers, Programs;
use Lexical_Analyzers, Programs;

package Parsers is

   type Parser is private;

   parser_exception: exception;

   function create_parser (file_name: in String) return Parser;

   procedure parse (p: in out Parser; prog: out Program);

private
   type Parser is
      record
         lex: Lexical_Analyzer;
      end record;

end Parsers;
