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
    /**
     * preconditions: booleanExpression is not null, cB1 is not null, cB2 is not null
     * postcondition: If_statement is created
     * @param booleanExpression
     * @param cB1
     * @param cB2
     */
    If_statement(BooleanExpression booleanExpression,Code_block cB1, Code_block cB2 )
    {
        if (booleanExpression == null)
            throw new IllegalArgumentException ("null BooleanExpression");
        if (cB1 == null || cB2 == null)
            throw new IllegalArgumentException ("null Code_block");
        this.booleanExpression=booleanExpression;
        this.cB1=cB1;
        this.cB2=cB2;
    }
    /**
     * Evaluates If_statement
     * @throws exceptions.UndefinedVariable if an undefined variable is in If_statement at evaluate time
     */
    public void evaluate() throws exceptions.UndefinedVariable
    {
        if(booleanExpression.evaluate())
            cB1.evaluate();
        else
            cB2.evaluate();
    }
}
