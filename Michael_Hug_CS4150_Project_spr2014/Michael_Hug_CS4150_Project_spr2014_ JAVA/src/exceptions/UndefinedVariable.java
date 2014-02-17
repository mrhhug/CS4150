/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */
package exceptions;

import lexicalanalyzer.Token;

public class UndefinedVariable extends Exception
{
    private final Character Id;
    private final int columnNumber;
    private final int rowNumber;
    /**
     * preconditions: Token is not null
     * @param token
     * @throws IllegalArgumentException if token is null
    */ 
    public UndefinedVariable(Token token) 
    {
        if (token == null)
            throw new IllegalArgumentException ("null token");
        rowNumber=token.getLineNumber();
        columnNumber=token.getColumnNumber();
        Id=token.getID();
    }
    public int getRowNumber()
    {
        return rowNumber;
    }
    public int getColumnNumber()
    {
        return columnNumber;
    }
    public Character getID()
    {
        return Id;
    }
}
