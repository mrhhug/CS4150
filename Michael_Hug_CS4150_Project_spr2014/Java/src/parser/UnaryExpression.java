/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package parser;

import lexicalanalyzer.Token;

public abstract class UnaryExpression implements Expression 
{
    Token token;
    /**
     * preconditions: token is not null
     * postcondition: UnaryExpression is created
     * @param token 
     */
    UnaryExpression(Token token)
    {
        if (token == null)
            throw new IllegalArgumentException ("null Token");
        this.token=token;
    }
}

class IdUnaryExpression extends UnaryExpression
{           
    public IdUnaryExpression(Token token)
    {
        super(token);
    }
    /**
     * @return value of IdUnaryExpression
     * @throws exceptions.UndefinedVariable if an undefined variable is in IdUnaryExpression at evaluate time
     */
    public int evaluate() throws exceptions.UndefinedVariable
    {
        return globals.Memory.fetch(token);
    } 
}

class LiteralIntegerUnaryExpression extends UnaryExpression
{           
    public LiteralIntegerUnaryExpression(Token token)
    {
        super(token);
    }
    /**
     * @return value of LiteralIntegerUnaryExpression
     */
    public int evaluate()
    {
        return token.getLiteralInteger();
    } 
}