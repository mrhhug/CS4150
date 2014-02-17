/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package parser;

import java.util.List;

public class Code_block
{
    private final List<Statement> statementList;
    /**
     * preconditions: statementList is not null
     * postcondition: Code_block is created
     * @param statementList
     */
    Code_block(List<Statement> statementList)
    {
        if (statementList == null)
            throw new IllegalArgumentException ("null Statement List");
        this.statementList = statementList;
    }
    /**
     * evaluates Code_block
     * @throws exceptions.UndefinedVariable if an undefined variable is in Code_block at evaluate time
     */
    void evaluate() throws exceptions.UndefinedVariable
    {
        for(Statement s : statementList)
                s.evaluate();
    }
}