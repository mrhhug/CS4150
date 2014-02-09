/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package parser;

import exceptions.RuntimeError;

interface statemeniInterface
{
    /**
     * evaluates statement
     */
    void evaluate() throws RuntimeError;
}