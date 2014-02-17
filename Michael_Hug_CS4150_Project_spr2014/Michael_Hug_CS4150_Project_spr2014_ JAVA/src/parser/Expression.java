/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */
package parser;

import exceptions.LexException;
import exceptions.UndefinedVariable;

public interface Expression
{
    /**
     * @return value of expression
     * @throws UndefinedVariable if an undefined variable is in Statement at evaluate time
     * @throws LexException if a lexeme is unknown
     */
    int evaluate() throws UndefinedVariable, LexException;
}