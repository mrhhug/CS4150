/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package exceptions;

import lexicalanalyzer.Token;

public class RuntimeError extends Exception
{
    public RuntimeError(String s,Token t) 
    {
        System.out.println("Rutime Error : {"+s+"} occured at line number "+t.getlineNumber()+", column number "+t.getcolNumber());
        System.exit(2);
    }
}
