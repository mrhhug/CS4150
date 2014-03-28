/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */
package parser;

import static globals.KeywordLexeme.*;

import exceptions.LexException;
import exceptions.UndefinedVariable;
import java.util.List;
import lexicalanalyzer.Token;
import lexicalanalyzer.Tokenizer;

public class Parser
{
    Tokenizer TokenList; 
    /** 
    * precondition: TokenList is not null
     * @param TokenList
     * @throws LexException if an expected lexeme is not found
     * @throws UndefinedVariable if an undefined variable exist at evaluate time
     */
    public Parser(Tokenizer TokenList) throws LexException, UndefinedVariable
    {
        if (TokenList == null)
            throw new IllegalArgumentException ("null TokenList");
        this.TokenList = TokenList;
        doit();
    }
    private void doit() throws LexException, UndefinedVariable
    {
        Program program;
        
        while(TokenList.peek().getKeyword()!=EOF )
        {
            program = getProgram();
            program.evaluate();
        }
    }
    /**
     * @return program
     * @throws LexException if an expected lexeme is not found
     */
    private Program getProgram() throws LexException
    {
        Program program;
        Token token;
        
        token = TokenList.pop();
        if(token.getKeyword()!=DEF)
            throw new LexException("New program keyword expected: 'def' keyword not found",token);
        
        program = new Program(getCodeblock());
        
        token = TokenList.pop();
        if(token.getKeyword()!=END)
            throw new LexException("Program terminater keyword expected: 'end' keyword not found",token);
        
        return program;
    }
    /**
     * @return code_block
     * @throws LexException if an expected lexeme is not found
     */
    private Code_block getCodeblock() throws LexException
    {
        return new Code_block(getStatementList());
    }
    /**
     * @return statementList
     * @throws LexException if an expected lexeme is not found
     */
    private List<Statement> getStatementList() throws LexException
    {
        List<Statement> statementList = new java.util.LinkedList<>();
        
        while(TokenList.peek().getKeyword()==IF || TokenList.peek().getKeyword()==WHILE || 
                TokenList.peek().getKeyword()==ID || TokenList.peek().getKeyword()==PUTS || TokenList.peek().getKeyword()==UNTIL)
            statementList.add(getStatement());
        
        return statementList;
    }
    /**
     * @return statement
     * @throws LexException if an expected lexeme is not found
     */
    private Statement getStatement() throws LexException
    {
        Statement statement;
        
        switch(TokenList.peek().getKeyword())
        {
            case IF : statement = getIfstatement();
                break;
            case WHILE : statement = getAbstractloop();
                break;
            case UNTIL : statement = getAbstractloop();
                break;
            case ID : statement = newAssignstatement();
                break;
            case PUTS : statement = newPrintstatement();
                break;
            default:
                throw new LexException("statement initializing lexeme expected",TokenList.peek());
        }
        return statement;
    }
    /**
     * @return abstractloop
     * @throws LexException if an expected lexeme is not found
     */
    private AbstractLoop getAbstractloop() throws LexException
    {
        AbstractLoop abstractloop;
        BooleanExpression booleanExpression;
        Code_block code_block;
        Token looptoken;
        Token token;
        
        looptoken = TokenList.pop();
        
        booleanExpression = getBoolean_expression();
        
        token = TokenList.pop();
        if(token.getKeyword()!=DO)
            throw new LexException("loop do keyword expected: 'do' token not found",token);
        
        code_block = getCodeblock(); 
        
        token = TokenList.pop();
        if(token.getKeyword()!=END)
            throw new LexException("loop terminator keyword expected: 'end' token not found",token);
        
        if(looptoken.getKeyword()==UNTIL)
            abstractloop = new UntilStatement(booleanExpression,code_block);
        else if(looptoken.getKeyword()==WHILE)
            abstractloop = new WhileStatement(booleanExpression,code_block);
        else
            throw new LexException("loop initializing lexeme expected",TokenList.peek());
        
        return abstractloop;
    }
    /**
     * @return expression
     * @throws LexException if an expected lexeme is not found
     */
    private Expression getExpression() throws LexException
    {
        Expression expression;
        Expression expression1;
        Expression expression2;
        Token token;
        
        if (TokenList.peek().isID())
            expression = new IdUnaryExpression(TokenList.pop());
        
        else if (TokenList.peek().isLiteralInteger())
            expression = new LiteralIntegerUnaryExpression(TokenList.pop());
        
        else if (TokenList.peek().isArithmeticOperator())
        {
            token = TokenList.pop();
            expression1 = getExpression();
            expression2 = getExpression();
            expression =  new BinaryExpression (token, expression1, expression2);
        }
        else
            throw new LexException("Expression initializing lexeme expected",TokenList.peek());
        
        return expression;
    }
    /**
     * @return booleanExpression
     * @throws LexException if an expected lexeme is not found
     */
    private BooleanExpression getBoolean_expression() throws LexException
    {
        Token token;
        Expression expression1;
        Expression expression2;
        
        token = TokenList.pop();
        if(!token.isRelationalOperator())
            throw new LexException("RelationOperator expected",token);
        
        expression1 = getExpression();
        expression2 = getExpression();
        
        return new BooleanExpression(token,expression1,expression2);
    }
    /**
     * @return if_statement
     * @throws LexException if an expected lexeme is not found
     */
    private If_statement getIfstatement() throws LexException
    {
        BooleanExpression booleanExpression;
        Code_block code_block1;
        Code_block code_block2;
        Token token;
        
        token = TokenList.pop();
        if(token.getKeyword()!=IF)
            throw new LexException("new if_statment token expected: 'if' keyword not found",token);
        
        booleanExpression = getBoolean_expression(); 
        
        token = TokenList.pop();
        if(token.getKeyword()!=THEN)
            throw new LexException("if_statment then keyword expected: 'then' token not found",token);
        
        code_block1 = getCodeblock();
        
        token = TokenList.pop();
        if(token.getKeyword()!=ELSE)
            throw new LexException("if_statment do keyword expected: 'else' token not found",token);
        
        code_block2 = getCodeblock(); 
        
        token = TokenList.pop();
        if(token.getKeyword()!=END)
            throw new LexException("if_statment terminator keyword expected: 'end' token not found",token);
        
        return new If_statement(booleanExpression,code_block1,code_block2);
    }
    /**
     * @return assignmentStatement
     * @throws LexException if an expected lexeme is not found
     */
    private AssignmentStatement newAssignstatement() throws LexException
    {
        Token IDtoken;
        Token token;
        
        IDtoken = TokenList.pop();
        if(!IDtoken.isID())
            throw new LexException("id expected",IDtoken);
        
        token = TokenList.pop();
        if(token.getKeyword()!=ASSIGN)
            throw new LexException("= expected",token);
        
        return new AssignmentStatement(IDtoken,getExpression());
    }
    /**
     * @return print_statement
     * @throws LexException if an expected lexeme is not found
     */
    private Print_statement newPrintstatement() throws LexException
    {
        if(TokenList.pop().getKeyword()!=PUTS)
            throw new LexException("PUTS expected",TokenList.peek());
        
        return new Print_statement(getExpression()); 
    }
}