/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package parser;

class If_statement implements Statement
{
    private final BooleanExpression booleanExpression;
    private final Code_block cB1;
    private final Code_block cB2;
    
    If_statement(BooleanExpression booleanExpression,Code_block cB1, Code_block cB2 )
    {
        this.booleanExpression=booleanExpression;
        this.cB1=cB1;
        this.cB2=cB2;
    }
    public void evaluate() throws exceptions.UndefinedVariable
    {
        if(booleanExpression.evaluate())
            cB1.evaluate();
        else
            cB2.evaluate();
    }
}
