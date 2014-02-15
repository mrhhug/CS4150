/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package parser;

import globals.ArithmeticOperatorLexeme;
import static globals.KeywordLexeme.*;
import globals.Lexeme;
import globals.RelationalOperatorLexeme;

import exceptions.LexException;
import exceptions.UndefinedVariable;
import java.util.List;
import lexicalanalyzer.Token;
import lexicalanalyzer.Tokenizer;

public class Parser
{
    Tokenizer tl; 
    
    public Parser(Tokenizer tl) throws LexException, UndefinedVariable
    {
        this.tl = tl;
        doit();
    }
    private void doit() throws LexException, UndefinedVariable
    {
        Program p;
        while(tl.peek().getLexeme()!=EOF )
        {
            p = getProgram();
            p.evaluate();
        }
    }
    private Program getProgram() throws LexException
    {
        if(tl.pop().getLexeme()!=DEF)
            throw new LexException("New program keyword expected: 'def' keyword not found",tl.peek());
        Program p = new Program(getCodeblock());
        if(tl.pop().getLexeme()!=END)
            throw new LexException("Program terminater keyword expected: 'end' keyword not found",tl.peek());
        return p;
    }
    private Code_block getCodeblock() throws LexException
    {
        return new Code_block(getStatementList());
    }
    private List<Statement> getStatementList() throws LexException
    {
        List<Statement> sl = new java.util.LinkedList<>();
        while(nexttokenBeginsStatement(tl.peek().getLexeme()))
            sl.add(getStatement());
        return sl;
    }
    ///use lanbda 
    private boolean nexttokenBeginsStatement(Lexeme l)
    {
        return l==IF || l==WHILE || l==ID || l==PUTS || l==UNTIL;   
    }
    
    //change to switch? we know we are getting the correct tokens
    private Statement getStatement() throws LexException
    {
        Statement s;
        Lexeme l = tl.peek().getLexeme();
        if(l==IF)
            s = getIfstatement();
        else if(l==WHILE || l==UNTIL)
            s = getAbstractloop();
        else if(l==ID)
            s = newAssignstatement();
        else 
            s = newPrintstatement();
        return s;
    }
    private AbstractLoop getAbstractloop() throws LexException
    {
        AbstractLoop al;
        Token t = tl.pop();
        BooleanExpression be = getBoolean_expression();
        if(tl.pop().getLexeme()!=DO)
            throw new LexException("loop do keyword expected: 'do' token not found",tl.peek());
        Code_block cb = getCodeblock(); 
        if(tl.pop().getLexeme()!=END)
            throw new LexException("loop terminator keyword expected: 'end' token not found",tl.peek());
        if(t.getLexeme()==UNTIL)
            al = new UntilStatement(be,cb);
        else
            al = new WhileStatement(be,cb);
        return al;
    }
    private Expression getExpression() throws LexException
    {
        Expression e = null;
        if (tl.peek().getLexeme() == ID)
            e = new IdUnaryExpression(tl.pop());
        else if (tl.peek().getLexeme() == LI)
            e = new LiteralIntegerUnaryExpression(tl.pop());
        else if (ArithmeticOperatorLexeme.promoteLexeme(tl.peek().getLexeme())!=null)
        {
            ArithmeticOperatorLexeme ao = ArithmeticOperatorLexeme.promoteLexeme(tl.pop().getLexeme());
            Expression e0 = getExpression();
            Expression e1 = getExpression();
            e =  new BinaryExpression (ao, e0, e1);
        }
        if(e==null)
            throw new LexException("Expression expected",tl.peek());
        return e;
    }
    private BooleanExpression getBoolean_expression() throws LexException
    {
        if(RelationalOperatorLexeme.promoteLexeme(tl.peek().getLexeme())==null)
            throw new LexException("RelationOperator expected",tl.peek());
        RelationalOperatorLexeme ro = RelationalOperatorLexeme.promoteLexeme(tl.pop().getLexeme());
        Expression e0 = getExpression();
        Expression e1 = getExpression();
        return new BooleanExpression(ro,e0,e1);
    }
    private If_statement getIfstatement() throws LexException
    {
        if(tl.pop().getLexeme()!=IF)
            throw new LexException("new if_statment token expected: 'if' keyword not found",tl.peek());
        BooleanExpression be = getBoolean_expression(); 
        if(tl.pop().getLexeme()!=THEN)
            throw new LexException("if_statment then keyword expected: 'then' token not found",tl.peek());
        Code_block cb0 = getCodeblock(); 
        if(tl.pop().getLexeme()!=ELSE)
            throw new LexException("if_statment do keyword expected: 'else' token not found",tl.peek());
        Code_block cb1 = getCodeblock(); 
        if(tl.pop().getLexeme()!=END)
            throw new LexException("if_statment terminator keyword expected: 'end' token not found",tl.peek());
        return new If_statement(be,cb0,cb1);
    }
    private AssignmentStatement newAssignstatement() throws LexException
    {
        if(tl.peek().getLexeme()!=ID)
            throw new LexException("id expected",tl.peek());
        Token t = tl.pop();
        if(tl.pop().getLexeme()!=ASSIGN)
            throw new LexException("= expected",tl.peek());
        return new AssignmentStatement(t,getExpression());
    }
    private Print_statement newPrintstatement() throws LexException
    {
        if(tl.pop().getLexeme()!=PUTS)
            throw new LexException("PUTS expected",tl.peek());
        return new Print_statement(getExpression()); 
    }
}