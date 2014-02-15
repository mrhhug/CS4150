/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package exceptions;

public class LexException extends Exception
{
    private final int rowNumber;
    private final int columnNumber;
    /**
     * preconditions: message is not null, tokenrowNumber > 0, tokencolumnNumber > 0
     * @param message
     * @param token
     * @throws IllegalArgumentException if message is null, rowNumber <= 0, or columnNumber <= 0
    */   
    public LexException(String message,lexicalanalyzer.Token token) 
    {
        super (message);
        if (message == null)
            throw new IllegalArgumentException ("null string argument");
        if (token.getLineNumber() <= 0)
            throw new IllegalArgumentException ("invalid row number argument");
        if (token.getColumnNumber() <= 0)
            throw new IllegalArgumentException ("invalid column number argument");
        rowNumber=token.getLineNumber();
        columnNumber=token.getColumnNumber();
    }
    public int getRowNumber()
    {
        return rowNumber;
    }
    public int getColumnNumber()
    {
        return columnNumber;
    }
}
