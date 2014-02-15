/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package parser;

class Print_statement implements Statement
{
    Expression expr;
    
    public Print_statement(Expression expr)
    {
        this.expr = expr;
    }

    @Override
    public void evaluate() throws exceptions.UndefinedVariable
    {
        //ruby appends newline to puts
        System.out.println(expr.evaluate());
    }  
}
