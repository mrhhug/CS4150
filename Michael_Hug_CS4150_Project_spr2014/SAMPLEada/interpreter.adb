with Parsers, Programs, Lexical_Analyzers, Ada.Text_IO, Ada.Exceptions;
use Parsers, Programs, Lexical_analyzers, Ada.Text_IO, Ada.Exceptions;

procedure Interpreter is

   p: Parser;
   prog: Program;

begin
   p := create_parser ("test5.rb");
   parse (p, prog);
   execute (prog);
exception
   when e: lexical_exception =>
      put_line (exception_information (e));
   when e: parser_exception =>
      put_line (exception_information (e));
   when others =>
      put_line ("unknown error - terminating");
end Interpreter;
