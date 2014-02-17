/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */
package parser;

import exceptions.LexException;
import exceptions.UndefinedVariable;

class If_statement implements Statement
{
    private final BooleanExpression booleanExpression;
    private final Code_block code_block1;
    private final Code_block code_block2;
    /**
     * preconditions: booleanExpression is not null, code_block1 is not null, code_block2 is not null
     * postcondition: If_statement is created
     * @param booleanExpression
     * @param code_block1
     * @param code_block2
     */
    If_statement(BooleanExpression booleanExpression,Code_block code_block1, Code_block code_block2 )
    {
        if (booleanExpression == null)
            throw new IllegalArgumentException ("null BooleanExpression");
        if (code_block1 == null || code_block2 == null)
            throw new IllegalArgumentException ("null Code_block");
        this.booleanExpression=booleanExpression;
        this.code_block1=code_block1;
        this.code_block2=code_block2;
    }
    /**
     * Evaluates If_statement
     * @throws UndefinedVariable if an undefined variable is in If_statement at evaluate time
     * @throws LexException if a lexeme is unknown
     */
    public void evaluate() throws UndefinedVariable, LexException
    {
        if(booleanExpression.evaluate())
            code_block1.evaluate();
        else
            code_block2.evaluate();
    }
}
