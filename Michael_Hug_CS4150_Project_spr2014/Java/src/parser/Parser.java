/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package parser;

import globals.ArithmeticOperatorLexeme;
import static globals.KeywordLexeme.*;
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
        while(tl.peek().getKeyword()!=EOF )
        {
            p = getProgram();
            p.evaluate();
        }
    }
    private Program getProgram() throws LexException
    {
        if(tl.pop().getKeyword()!=DEF)
            throw new LexException("New program keyword expected: 'def' keyword not found",tl.peek());
        Program p = new Program(getCodeblock());
        if(tl.pop().getKeyword()!=END)
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
        while(tl.peek().getKeyword()==IF || tl.peek().getKeyword()==WHILE || 
                tl.peek().getKeyword()==ID || tl.peek().getKeyword()==PUTS || tl.peek().getKeyword()==UNTIL)
            sl.add(getStatement());
        return sl;
    }    
    private Statement getStatement() throws LexException
    {
        Statement s;
        switch(tl.peek().getKeyword())
        {
            case IF : s = getIfstatement();
                break;
            case WHILE : s = getAbstractloop();
                break;
            case UNTIL : s = getAbstractloop();
                break;
            case ID : s = newAssignstatement();
                break;
            default : s = newPrintstatement();
                break;
        }
        return s;
    }
    private AbstractLoop getAbstractloop() throws LexException
    {
        AbstractLoop al;
        Token t = tl.pop();
        BooleanExpression be = getBoolean_expression();
        if(tl.pop().getKeyword()!=DO)
            throw new LexException("loop do keyword expected: 'do' token not found",tl.peek());
        Code_block cb = getCodeblock(); 
        if(tl.pop().getKeyword()!=END)
            throw new LexException("loop terminator keyword expected: 'end' token not found",tl.peek());
        if(t.getKeyword()==UNTIL)
            al = new UntilStatement(be,cb);
        else
            al = new WhileStatement(be,cb);
        return al;
    }
    private Expression getExpression() throws LexException
    {
        Expression e = null;
        if (tl.peek().isID())
            e = new IdUnaryExpression(tl.pop());
        else if (tl.peek().isLiteralInteger())
            e = new LiteralIntegerUnaryExpression(tl.pop());
        else if (tl.peek().isArithmeticOperator())
        {
            ArithmeticOperatorLexeme ao = tl.pop().getArithmeticOperator();
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
        if(!tl.peek().isRelationalOperator())
            throw new LexException("RelationOperator expected",tl.peek());
        RelationalOperatorLexeme ro = tl.pop().getRelationalOperator();
        Expression e0 = getExpression();
        Expression e1 = getExpression();
        return new BooleanExpression(ro,e0,e1);
    }
    private If_statement getIfstatement() throws LexException
    {
        if(tl.pop().getKeyword()!=IF)
            throw new LexException("new if_statment token expected: 'if' keyword not found",tl.peek());
        BooleanExpression be = getBoolean_expression(); 
        if(tl.pop().getKeyword()!=THEN)
            throw new LexException("if_statment then keyword expected: 'then' token not found",tl.peek());
        Code_block cb0 = getCodeblock(); 
        if(tl.pop().getKeyword()!=ELSE)
            throw new LexException("if_statment do keyword expected: 'else' token not found",tl.peek());
        Code_block cb1 = getCodeblock(); 
        if(tl.pop().getKeyword()!=END)
            throw new LexException("if_statment terminator keyword expected: 'end' token not found",tl.peek());
        return new If_statement(be,cb0,cb1);
    }
    private AssignmentStatement newAssignstatement() throws LexException
    {
        if(tl.peek().getKeyword()!=ID)
            throw new LexException("id expected",tl.peek());
        Token t = tl.pop();
        if(tl.pop().getKeyword()!=ASSIGN)
            throw new LexException("= expected",tl.peek());
        return new AssignmentStatement(t,getExpression());
    }
    private Print_statement newPrintstatement() throws LexException
    {
        if(tl.pop().getKeyword()!=PUTS)
            throw new LexException("PUTS expected",tl.peek());
        return new Print_statement(getExpression()); 
    }
}