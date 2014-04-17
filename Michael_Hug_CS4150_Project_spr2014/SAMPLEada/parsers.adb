with Statements,Tokens,Expressions,Boolean_Expressions,Ids;
use Statements, Tokens,Expressions,Boolean_Expressions,Ids;

package body Parsers is

   function getCodeBlock return Code_Block;
   function isValidStartOfStatement(tok: in Token) return Boolean;
   function getStatement return Statement;
   function getWhileStatement return Statement;
   function getUntilStatement return Statement;
   function getIfStatement return Statement;
   function getPrintStatement return Statement;
   function getAssignmentStatement return Statement;
   function getExpression return Expression;
   function getArithmeticOperator return Arithmetic_Operator;
   function getBooleanExpression return Boolean_Expression;
   function getRelationalOperator return Relational_Operator;
   procedure match(tok: in Token; tt: in Token_Type);
   function getNextToken return Token;
   function getLookaheadToken return Token;

   -------------------
   -- create_parser --
   -------------------

   function create_parser (file_name: in String) return Parser is
   begin
      --  Generated stub: replace with real body!
      raise Program_Error with "Unimplemented function create_parser";
      return create_parser (file_name);
   end create_parser;

   -----------
   -- parse --
   -----------

   procedure parse (p: in out Parser; prog: out Program) is
   begin
      raise Program_Error with "Unimplemented function create_parser";
   end parse;

   ----------------------------------------------------------------------------

   function getCodeBlock return Code_Block is

      cb : Code_Block;
      stmt : Statement := getStatement;
      tok : Token;

   begin
      tok := getLookaheadToken;
      return cb;
   end getCodeBlock;

   ----------------------------------------------------------------------------

   function isValidStartOfStatement(tok: in Token) return Boolean is

   begin
      return True;
   end isValidStartOfStatement;

   ----------------------------------------------------------------------------

   function getStatement return Statement is

      stmt : Statement;

   begin
      return stmt;
   end getStatement;

   ----------------------------------------------------------------------------

   function getWhileStatement return Statement is

      stmt : Statement;

   begin
      return stmt;
   end getWhileStatement;

   ----------------------------------------------------------------------------

   function getUntilStatement return Statement is

      stmt : Statement;

   begin
      return stmt;
   end getUntilStatement;

   ----------------------------------------------------------------------------

   function getIfStatement return Statement is

      stmt : Statement;

   begin
      return stmt;
   end getIfStatement;

   ----------------------------------------------------------------------------

   function getPrintStatement return Statement is

      tok : Token := getNextToken;
      expr : Expression :=getExpression;

   begin
      match (tok, PUTS_TOK);
      return create_print_statement(expr);
   end getPrintStatement;

   ----------------------------------------------------------------------------

   function getAssignmentStatement return Statement is

      tok : Token := getNextToken;
      var : Id;

   begin
      match (tok, ID_TOK);
      var := create_id(get_char(get_lexeme(tok)));
   end getAssignmentStatement;

   ----------------------------------------------------------------------------

   function getExpression return Expression is

      expr : Expression;
      tok : Token := getLookaheadToken;

   begin
      return expr;
   end getExpression;

   ----------------------------------------------------------------------------

   function getArithmeticOperator return Arithmetic_Operator is

      op : Arithmetic_Operator;
      tok : Token := getNextToken;

   begin
      return op;
   end getArithmeticOperator;

   ----------------------------------------------------------------------------

   function getBooleanExpression return Boolean_Expression is

      op : Relational_Operator := getRelationalOperator;
      expr1 : Expression := getExpression;
      expr2 : Expression := getExpression;

   begin
      return Boolean_Expression;
   end getBooleanExpression;

   ----------------------------------------------------------------------------

   function getUntilStatement return Statement is

      stmt : Statement;

   begin
      return stmt;
   end getUntilStatement;




end Parsers;
