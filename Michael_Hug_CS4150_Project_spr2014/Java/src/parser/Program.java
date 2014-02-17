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
    /**
     * preconditions: cB is not null
     * postcondition: Program is created
     * @param cB 
     */
    Program(Code_block cB)
    {
        if (cB == null)
            throw new IllegalArgumentException ("null Code_block");
        this.cB = cB;
    }
    /**
     * evaluates Program
     * @throws exceptions.UndefinedVariable if an undefined variable is in Program at evaluate time
     */
    void evaluate() throws exceptions.UndefinedVariable
    {
        cB.evaluate();
    }
}
