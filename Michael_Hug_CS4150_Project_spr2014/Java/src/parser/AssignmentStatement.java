/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package parser;

import lexicalanalyzer.Token;

public class AssignmentStatement implements Statement
{
    Token token;
    Expression expr;
    
    /**
     * preconditions: token is not null, expr is not null
     * postcondition: Assignment statement is created
     * @param token
     * @param expr
     */
    public AssignmentStatement(Token token, Expression expr)
    {
        if (token == null)
            throw new IllegalArgumentException ("null Token");
        if (expr == null)
            throw new IllegalArgumentException ("null Expression");
        this.token=token;
        this.expr=expr;
    }

    @Override
    public void evaluate() throws exceptions.UndefinedVariable
    {
        globals.Memory.store(token,expr.evaluate());
    }   
}
