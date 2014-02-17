/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */
package parser;

import exceptions.LexException;
import exceptions.UndefinedVariable;
import globals.Memory;
import lexicalanalyzer.Token;

public class AssignmentStatement implements Statement
{
    Expression expression;
    Token token;
    /**
     * preconditions: token is ID token, expression is not null
     * postcondition: Assignment statement is created
     * @param token
     * @param expression
     */
    public AssignmentStatement(Token token, Expression expression)
    {
        if (!token.isID())
            throw new IllegalArgumentException ("ID token expected");
        
        if (expression == null)
            throw new IllegalArgumentException ("null Expression");
        
        this.token=token;
        this.expression=expression;
    }
    @Override
    public void evaluate() throws UndefinedVariable, LexException
    {
        Memory.store(token,expression.evaluate());
    }   
}
