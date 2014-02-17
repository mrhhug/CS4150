/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */
package parser;

import exceptions.LexException;
import exceptions.UndefinedVariable;

public abstract class AbstractLoop implements Statement
{
    BooleanExpression booleanExpression;
    Code_block code_block;
    /**
     * preconditions: booleanExpression is not null, cB is not null
     * postcondition: AbstractLoop is created
     * @param booleanExpression
     * @param code_block
     */
    AbstractLoop(BooleanExpression booleanExpression,Code_block code_block)
    {
        if (booleanExpression == null)
            throw new IllegalArgumentException ("null booleanExpression");
        if (code_block == null)
            throw new IllegalArgumentException ("null code_block");
        this.booleanExpression=booleanExpression;
        this.code_block=code_block;
    }
}
class WhileStatement extends AbstractLoop
{
    public WhileStatement(BooleanExpression booleanExpression, Code_block code_block)
    {
        super(booleanExpression, code_block);
    }
    @Override
    public void evaluate() throws UndefinedVariable, LexException
    {
        while(booleanExpression.evaluate())
            code_block.evaluate();
    } 
}
class UntilStatement extends AbstractLoop
{
    public UntilStatement(BooleanExpression booleanExpression, Code_block code_block)
    {
        super(booleanExpression, code_block);
    }
    @Override
    public void evaluate() throws UndefinedVariable, LexException
    {
        while(!booleanExpression.evaluate())
            code_block.evaluate();
    } 
}