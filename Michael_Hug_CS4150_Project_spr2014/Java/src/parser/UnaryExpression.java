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
    
    UnaryExpression(Token token)
    {
        this.token=token;
    }
}

class IdUnaryExpression extends UnaryExpression
{           
    public IdUnaryExpression(Token token)
    {
        super(token);
    }
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
    public int evaluate()
    {
        return token.getLiteralInteger();
    } 
}