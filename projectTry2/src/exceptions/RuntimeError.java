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
