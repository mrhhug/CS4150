/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package exceptions;

public class UndefinedVariable extends Exception
{
    private final int rowNumber;
    private final int columnNumber;
    private final Character Id;
    
    public UndefinedVariable(lexicalanalyzer.Token token) 
    {
        if (token.getLineNumber() <= 0)
            throw new IllegalArgumentException ("invalid row number argument");
        if (token.getColumnNumber() <= 0)
            throw new IllegalArgumentException ("invalid column number argument");
        rowNumber=token.getLineNumber();
        columnNumber=token.getColumnNumber();
        Id=token.getCharacter();
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
