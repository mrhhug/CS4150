/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package parser;

public interface Expression
{
    /**
     * @return value of expression
     * @throws exceptions.UndefinedVariable
     */
    int evaluate() throws exceptions.UndefinedVariable;
}