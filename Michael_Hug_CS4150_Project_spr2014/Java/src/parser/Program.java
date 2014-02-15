/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package parser;

class Program
{
    Code_block cB;
    
    Program(Code_block cB)
    {
        this.cB = cB;
    }
    void evaluate() throws exceptions.UndefinedVariable
    {
        cB.evaluate();
    }
}
