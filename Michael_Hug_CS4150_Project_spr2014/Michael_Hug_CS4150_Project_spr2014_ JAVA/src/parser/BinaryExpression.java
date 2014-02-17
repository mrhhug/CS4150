/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */
package parser;

import exceptions.LexException;
import exceptions.UndefinedVariable;
import lexicalanalyzer.Token;

public class BinaryExpression implements Expression
{
    private Expression expression1;
    private Expression expression2;
    private Token token;
    /**
     * precondition: token is arithmeticOperator, expression1 is not null, expression2 is not null
     * postcondition: BinaryExpression is created
     * @param token
     * @param expression1
     * @param expression2
     */
    public BinaryExpression(Token token, Expression expression1, Expression expression2)
    {
        if (!token.isArithmeticOperator())
            throw new IllegalArgumentException ("ArithmeticOperator expected");
        if (expression1 == null || expression2 == null)
            throw new IllegalArgumentException ("null expression argument");
        this.token = token;
        this.expression1 = expression1;
        this.expression2 = expression2;
    }
    /**
     * @return value of the BinaryExpression
     * @throws UndefinedVariable if an undefined variable is in Statement at evaluate time
     * @throws LexException if a lexeme is unknown
     */
    public int evaluate() throws UndefinedVariable, LexException
    {
        int value = 0;
        
        switch (token.getArithmeticOperator())
        {
            case ADD:
                value = expression1.evaluate() + expression2.evaluate();
                break;
            case SUB:
                value = expression1.evaluate() - expression2.evaluate();
                break;
            case MUL:
                value = expression1.evaluate() * expression2.evaluate();
                break;
            case DIV:
                value = expression1.evaluate() / expression2.evaluate();
                break;
            default:
                throw new LexException("ArithmeticOperator expected",token);
        }
        
        return value;
    }	
}