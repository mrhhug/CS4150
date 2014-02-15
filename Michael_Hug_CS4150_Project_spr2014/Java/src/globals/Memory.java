/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */
package globals;

import exceptions.UndefinedVariable;
import lexicalanalyzer.Token;

public class Memory
{

    private static final Integer[] mem = new Integer[52];

    /**
     * @param token
     * @return value stored for specified variable
     * @throws exceptions.UndefinedVariable
     */
    public static int fetch(Token token) throws UndefinedVariable
    {
        Integer intgr = mem[getArrayIndex(token.getCharacter())];
        if(intgr==null)
            throw new UndefinedVariable(token);
        return intgr;
    }

    /**
     * postcondition: value has been stored as the value of the specified variable
     * @param token
     * @param value
     */
    public static void store(Token token, int value)
    {
        mem[getArrayIndex(token.getCharacter())] = value;
    }
    private static int getArrayIndex(char minuend)
    {
        int subtrahend = (minuend<91) ? 65 : 97;
        return minuend - subtrahend;
    }
}
