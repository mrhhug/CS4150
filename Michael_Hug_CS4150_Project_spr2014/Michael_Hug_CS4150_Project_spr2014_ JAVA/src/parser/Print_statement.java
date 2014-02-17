/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package parser;

import exceptions.LexException;

class Print_statement implements Statement
{
    Expression expression;
    /**
     * preconditions: expression is not null
     * postcondition: Print_statement is created
     * @param expression
     */
    public Print_statement(Expression expression)
    {
        if (expression == null)
            throw new IllegalArgumentException ("null Print_statement");
        this.expression = expression;
    }
    @Override
    public void evaluate() throws exceptions.UndefinedVariable, LexException
    {
        //ruby appends newline to puts
        System.out.println(expression.evaluate());
    }  
}
