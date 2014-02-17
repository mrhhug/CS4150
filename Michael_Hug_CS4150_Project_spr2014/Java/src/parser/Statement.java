/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package parser;

interface Statement
{
    /**
     * evaluates statement
     * @throws exceptions.UndefinedVariable if an undefined variable is in Statement at evaluate time
     */
    void evaluate() throws exceptions.UndefinedVariable;
}