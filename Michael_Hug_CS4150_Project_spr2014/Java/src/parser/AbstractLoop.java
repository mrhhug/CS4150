/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package parser;

import exceptions.UndefinedVariable;

public abstract class AbstractLoop implements Statement
{
    BooleanExpression booleanExpression;
    Code_block cB;
    /**
     * preconditions: booleanExpression is not null, cB is not null
     * postcondition: AbstractLoop is created
     * @param booleanExpression
     * @param cB
     */
    AbstractLoop(BooleanExpression booleanExpression,Code_block cB)
    {
        if (booleanExpression == null)
            throw new IllegalArgumentException ("null BooleanExpression");
        if (cB == null)
            throw new IllegalArgumentException ("null Code_block");
        this.booleanExpression=booleanExpression;
        this.cB=cB;
    }
}
class WhileStatement extends AbstractLoop
{
    public WhileStatement(BooleanExpression booleanExpression, Code_block cB)
    {
        super(booleanExpression, cB);
    }
    @Override
    public void evaluate() throws UndefinedVariable
    {
        while(booleanExpression.evaluate())
            cB.evaluate();
    } 
}
class UntilStatement extends AbstractLoop
{
    public UntilStatement(BooleanExpression booleanExpression, Code_block cB)
    {
        super(booleanExpression, cB);
    }
    @Override
    public void evaluate() throws UndefinedVariable
    {
        while(!booleanExpression.evaluate())
            cB.evaluate();
    } 
}