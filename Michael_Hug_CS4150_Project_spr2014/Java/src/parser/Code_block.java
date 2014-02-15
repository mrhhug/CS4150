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
    
    Code_block(List<Statement> statementList)
    {
        this.statementList = statementList;
    }
    void evaluate() throws exceptions.UndefinedVariable
    {
        for(Statement s : statementList)
                s.evaluate();
    }
}