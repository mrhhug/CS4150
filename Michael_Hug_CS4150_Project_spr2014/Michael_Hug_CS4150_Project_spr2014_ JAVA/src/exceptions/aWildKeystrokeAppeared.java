/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */
package exceptions;

public class aWildKeystrokeAppeared extends Exception
{
    private String gibberish;
    private int columnNumber;
    private int rowNumber;
    /**
     * preconditions: gibberish is not null, tokenrowNumber > 0, tokencolumnNumber > 0
     * @param gibberish
     * @param rowNumber
     * @param columnNumber
     * @throws IllegalArgumentException if message is null, rowNumber <= 0, or columnNumber <= 0
    */
    public aWildKeystrokeAppeared(String gibberish, int rowNumber, int columnNumber) 
    {
        if(gibberish==null)
            throw new IllegalArgumentException ("null string argument");
        if (rowNumber <= 0)
            throw new IllegalArgumentException ("invalid row number argument");
        if (columnNumber <= 0)
            throw new IllegalArgumentException ("invalid column number argument");
        this.gibberish=gibberish;
        this.rowNumber = rowNumber;
	this.columnNumber = columnNumber;
        
        //You could have entered a value outside the spectrum of a signed int32: -2,147,483,647 to 2,147,483,647");
        // check tatoo
        // http://stackoverflow.com/a/94608
    }
    /**
     * @return gibberish
     */
    public String getGibberish()
    {
        return gibberish;
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
