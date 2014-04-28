with Statements,Tokens,Expressions,Boolean_Expressions,Ids,Literal_Integers;
use Statements, Tokens,Expressions,Boolean_Expressions,Ids,Literal_Integers;

package body Parsers is

   function getCodeBlock return Code_Block;
   function isValidStartOfStatement(tok: in Token) return Boolean;
   function getStatement return Statement_Access;
   function getWhileStatement return Statement_Access;
   function getUntilStatement return Statement_Access;
   function getIfStatement return Statement_Access;
   function getPrintStatement return Statement_Access;
   function getAssignmentStatement return Statement_Access;
   procedure getExpression (p: in out Parser; ea:  out Expression_Access);
   procedure getArithmeticOperator (p: in out Parser; ao:  out Arithmetic_Operator);
   procedure getBooleanExpression (p: in out Parser; op:  out Boolean_Expression);
   procedure getRelationalOperator (p: in out Parser; op:  out Relational_Operator);
   procedure match(tok: in Token; tt: in Token_Type);
   function LexemeToString (lex: in Lexeme) return String;


   -------------------
   -- create_parser --
   -------------------

   function create_parser (file_name: in String) return Parser is

      Parse : Parser;

   begin
      Parse.lex:=create_lexical_analyzer(file_name);
      return Parse;
   end create_parser;

   -----------
   -- parse --
   -----------

   procedure parse (p: in out Parser; prog: out Program) is

      tok : Token;
      cb : Code_Block;

   begin
      get_next_token(p.lex,tok);
      match (tok, DEF_TOK);
      cb := getCodeBlock;
      get_next_token(p.lex,tok);
      match (tok, END_TOK);
      get_next_token(p.lex,tok);
      if (get_token_type(tok) /= EOS_TOK) then
         raise parser_exception with "garbage at end of program";
      end if;
      prog:=create_program(cb);
   end parse;

   ----------------------------------------------------------------------------

   function getCodeBlock return Code_Block is

      cb : Code_Block;
      stmt : Statement_Access;
      tok : Token;

   begin
      stmt:= getStatement;
      add(cb,stmt);
      --tok:= getlookaheadtoken;
      return cb;
   end getCodeBlock;

   ----------------------------------------------------------------------------

   function isValidStartOfStatement(tok: in Token) return Boolean is

   begin
      return get_token_type(tok) = IF_TOK and get_token_type(tok) = ID_TOK and get_token_type(tok) = WHILE_TOK and
      get_token_type(tok) = UNTIL_TOK and get_token_type(tok) = PUTS_TOK;
   end isValidStartOfStatement;

   ----------------------------------------------------------------------------

   function getStatement return Statement_Access is

      stmt : Statement_Access;
      tok : Token;

   begin
      --tok := getlookaheadtoken;
      if get_token_type(tok)=ID_TOK then
         stmt := getAssignmentStatement;
      elsif get_token_type(tok)=IF_TOK then
         stmt := getIfStatement;
      elsif get_token_type(tok)=PUTS_TOK then
         stmt := getPrintStatement;
      elsif get_token_type(tok)=UNTIL_TOK then
         stmt := getUntilStatement;
      elsif get_token_type(tok)=WHILE_TOK then
         stmt := getWhileStatement;
      else
         raise parser_exception with "statement expected at row " & Positive'Image(get_row_number(tok)) & " and column " & Positive'Image(get_column_number(tok));
      end if;
      return stmt;
   end getStatement;

   ----------------------------------------------------------------------------

   function getWhileStatement return Statement_Access is

      tok : Token;
      expr : Boolean_Expression;
      cb: Code_Block;

   begin
      --tok := getNextToken;
      match(tok,WHILE_TOK);
      --expr:= getBooleanExpression;
      --tok := getNextToken;
      match(tok,DO_TOK);
      cb:= getCodeBlock;
      --tok := getNextToken;
      match(tok,END_TOK);
      return create_while_statement(expr,cb);
   end getWhileStatement;

   ----------------------------------------------------------------------------

   function getUntilStatement return Statement_Access is

      tok : Token;
      expr : Boolean_Expression;
      cb: Code_Block;

   begin
      --tok := getNextToken;
      match(tok,UNTIL_TOK);
      --expr:= getBooleanExpression;
      --tok := getNextToken;
      match(tok,DO_TOK);
      cb := getCodeBlock;
      --tok := getNextToken;
      match(tok,END_TOK);
      return create_until_statement(expr,cb);
   end getUntilStatement;

   ----------------------------------------------------------------------------

   function getIfStatement return Statement_Access is

      tok : Token;
      expr : Boolean_Expression;
      cb1: Code_Block;
      cb2: Code_Block;

   begin
      --tok := getNextToken;
      match (tok, IF_TOK);
      --expr := getBooleanExpression;
      --tok := getNextToken;
      match (tok, THEN_TOK);
      cb1:= getCodeBlock;
      --tok := getNextToken;
      match (tok, ELSE_TOK);
      cb2:= getCodeBlock;
      --tok := getNextToken;
      match (tok, END_TOK);
      return create_if_statement(expr,cb1,cb2);
   end getIfStatement;

   ----------------------------------------------------------------------------

   function getPrintStatement return Statement_Access is

      tok : Token;
      expr : Expression_Access;

   begin
      --tok:= getNextToken;
      match (tok, PUTS_TOK);
      --expr:= getExpression;
      return create_print_statement(expr);
   end getPrintStatement;

   ----------------------------------------------------------------------------

   function getAssignmentStatement return Statement_Access is

      tok : Token;
      var : Id;
      expr : Expression_Access;

   begin
      --tok :=getNextToken;
      match (tok, ID_TOK);
      var := create_id(get_lexeme(tok)(1));
      --tok :=getNextToken;
      match (tok, ASSIGN_OP);
      --expr :=getExpression;
      return create_assignment_statement(var, expr);
   end getAssignmentStatement;

   ----------------------------------------------------------------------------

   procedure getExpression (p: in out Parser; ea:  out Expression_Access) is

      tok : Token;
      ao : Arithmetic_Operator;
      expr1 : Expression_Access;
      expr2 :Expression_Access;

   begin
      tok:= get_lookahead_token(p.lex);
      if get_token_type(tok)=ID_TOK then
         get_next_token(p.lex,tok);
         ea := create_var_expression(create_id(get_lexeme(tok)(1)));
      elsif get_token_type(tok)=LIT_INT then
         get_next_token(p.lex,tok);
         ea := create_const_expression(create_literal_integer(Integer'Value (LexemeToString(get_lexeme(tok)))));
      else
         -getArithmeticOperator(p,ao);
         getExpression(p,expr1);
         getExpression(p,expr2);
         ea := create_binary_expression(op,expr1,expr2);
      end if;
   end getExpression;

   ----------------------------------------------------------------------------

   procedure getArithmeticOperator (p: in out Parser; ao:  out Arithmetic_Operator) is

      tok : Token;

   begin
      get_next_token(p.lex,tok);
      case get_token_type(tok) is
         when ADD_TOK => ao:=ADD_OP;
         when SUB_TOK => ao:=SUB_OP;
         when MUL_TOK => ao:=MUL_OP;
         when DIV_TOK => ao:=DIV_OP;
         when others => raise parser_exception with "arithmetic operator expected at row " & Positive'Image(get_row_number(tok)) & " and column " & Positive'Image(get_column_number(tok));
      end case;
   end getArithmeticOperator;

   ----------------------------------------------------------------------------

   procedure getBooleanExpression (p: in out Parser; op:  out Boolean_Expression) is

      ro :Relational_Operator;
      expr1 : Expression_Access;
      expr2 : Expression_Access;

   begin
      getRelationalOperator(p,ro);
      --expr1:= getExpression;
      --expr2:= getExpression;
      op:= create_boolean_expression(ro, expr1, expr2);
   end getBooleanExpression;

   ----------------------------------------------------------------------------

   procedure getRelationalOperator (p: in out Parser; op:  out Relational_Operator) is

      tok : Token;

   begin
      get_next_token(p.lex,tok);
      case get_token_type(tok) is
         when NE_TOK => op:=NE_OP;
         when EQ_TOK => op:=EQ_OP;
         when LT_TOK => op:=LT_OP;
         when LE_TOK => op:=LE_OP;
         when GT_TOK => op:=GT_OP;
         when GE_TOK => op:=GE_OP;
         when others => raise parser_exception with "relational operator expected at row " & Positive'Image(get_row_number(tok)) & " and column " & Positive'Image(get_column_number(tok));
      end case;
   end getRelationalOperator;

   ----------------------------------------------------------------------------

   procedure match (tok: in Token; tt: in Token_Type) is

   begin
      if get_token_type(tok) /= tt then
         raise parser_exception with Token_Type'Image(tt) & " expected at row " & Positive'Image(get_row_number(tok)) & " and column " & Positive'Image(get_column_number(tok));
      end if;
   end match;

   ----------------------------------------------------------------------------

   function LexemeToString (lex: in Lexeme) return String is

      size: Positive := size_of_lexeme(lex);
      Str   : String (1 .. size);

   begin
      for i in Integer range 1 .. size loop
         Str(i) := lex(i);
      end loop;
      return str;
   end LexemeToString;

   ----------------------------------------------------------------------------

end Parsers;
