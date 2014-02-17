/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package parser;

import exceptions.LexException;
import exceptions.UndefinedVariable;

class Program
{
    Code_block code_block;
    /**
     * preconditions: code_block is not null
     * postcondition: Program is created
     * @param code_block 
     */
    Program(Code_block code_block)
    {
        if (code_block == null)
            throw new IllegalArgumentException ("null code_block");
        this.code_block = code_block;
    }
    /**
     * evaluates Program
     * @throws UndefinedVariable if an undefined variable is in Program at evaluate time
     */
    void evaluate() throws UndefinedVariable, LexException
    {
        code_block.evaluate();
    }
}
