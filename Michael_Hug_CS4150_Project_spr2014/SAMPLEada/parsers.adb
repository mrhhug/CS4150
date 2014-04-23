with Statements,Tokens,Expressions,Boolean_Expressions,Ids;
use Statements, Tokens,Expressions,Boolean_Expressions,Ids;

package body Parsers is

   function getCodeBlock return Code_Block;
   function isValidStartOfStatement(tok: in Token) return Boolean;
   function getStatement return Statement_Access;
   function getWhileStatement return Statement_Access;
   function getUntilStatement return Statement_Access;
   function getIfStatement return Statement_Access;
   function getPrintStatement return Statement_Access;
   function getAssignmentStatement return Statement_Access;
   function getExpression return Expression_Access;
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
      stmt : Statement_Access := getStatement;
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

   function getStatement return Statement_Access is

      stmt : Statement_Access;

   begin
      return stmt;
   end getStatement;

   ----------------------------------------------------------------------------

   function getWhileStatement return Statement_Access is

      stmt : Statement_Access;

   begin
      return stmt;
   end getWhileStatement;

   ----------------------------------------------------------------------------

   function getUntilStatement return Statement_Access is

      stmt : Statement_Access;

   begin
      return stmt;
   end getUntilStatement;

   ----------------------------------------------------------------------------

   function getIfStatement return Statement_Access is

      stmt : Statement_Access;

   begin
      return stmt;
   end getIfStatement;

   ----------------------------------------------------------------------------

   function getPrintStatement return Statement_Access is

      tok : Token := getNextToken;
      expr : Expression_Access :=getExpression;

   begin
      match (tok, PUTS_TOK);
      return create_print_statement(expr);
   end getPrintStatement;

   ----------------------------------------------------------------------------

   function getAssignmentStatement return Statement_Access is

      tok : Token;
      var : Id;
      expr : Expression_Access;
      char : Character;

   begin
      tok :=getNextToken;
      match (tok, ID_TOK);
      var := create_id(get_lexeme(tok)(1));
      tok :=getNextToken;
      match (tok, ASSIGN_OP);
      expr :=getExpression;
      return create_assignment_statement(var, expr);
   end getAssignmentStatement;

   ----------------------------------------------------------------------------

   function getExpression return Expression_Access is

      expr : Expression_Access;
      tok : Token;
      op : ArithmeticOperator;
      expr1 : Expression_Access;
      expr2 :Expression_Access;

   begin
      tok:= getLookaheadToken;

      if get_token_type(tok)=ID_TOK then
         tok := getNextToken;
         expr := create_id(get_lexeme(tok)(1));
      elsif get_token_type(tok)=LIT_INT then
         tok := getNextToken;
         expr := create_literal_integer(Integer'Value(get_lexeme(tok)));
      else
         op := getArithmeticOperator;
         expr1 := getExpression;
         expr2 := getExpression;
      end if;

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
      expr1 : Expression_Access := getExpression;
      expr2 : Expression_Access := getExpression;

   begin
      return create_boolean_expression(op, expr1, expr2);
   end getBooleanExpression;

   ----------------------------------------------------------------------------

end Parsers;
