/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package parser;

import exceptions.LexException;
import exceptions.UndefinedVariable;

interface Statement
{
    /**
     * evaluates statement
     * @throws UndefinedVariable if an undefined variable is in Statement at evaluate time
     * @throws LexException if a lexeme is unknown
     */
    void evaluate() throws UndefinedVariable, LexException;
}