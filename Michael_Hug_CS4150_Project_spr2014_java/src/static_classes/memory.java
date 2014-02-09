/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package static_classes;

import exceptions.RuntimeError;
import lexicalanalyzer.Token;

public class memory
{
    static Integer mem[] = new Integer[52];
    
    /**
     * postcondition: value has been stored as the value of the specified variable
     * @param t
     * @param i
     */
    public static void set(Token t, Integer i) throws RuntimeError
    {
        mem[getArrayIndex(t)]=i;
    }
    /**
     * @param t must be integer token
     * @return value stored for specified variable
     * @throws RuntimeError if variable has not been initialized
     */
    public static Integer get(Token t) throws RuntimeError
    {
        if(t.getCharacter()==null)
            throw new RuntimeError("integer token expected",t);
        Integer i = mem[getArrayIndex(t)];
        if(i==null)
            throw new RuntimeError("undefined variable",t);
        return i;
    }
    //A=65 , Z=90 , a = 97 , z = 122
    private static int getArrayIndex(Token t)
    {
        int index = t.getCharacter();
        if(index<91)
            index-=65;
        else
            index-=97;
        return index;
    }
}
