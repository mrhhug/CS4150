/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package lexicalanalyzer;

import globals.ArithmeticOperatorLexeme;
import globals.KeywordLexeme;
import globals.RelationalOperatorLexeme;

public class Token
{
    private ArithmeticOperatorLexeme aol;
    private Character ID;
    private KeywordLexeme kwl;
    private Integer litInt;
    private RelationalOperatorLexeme rol;
    private final int lineNum;
    private final int columnNum;
    /**
     * precondition: aol is not null, tokenrowNumber > 0, tokencolumnNumber > 0
     * postcondition: Token is created
     * @param aol
     * @param lineNum
     * @param columnNum
     * @throws IllegalArgumentException if aol is null, rowNumber <= 0, or columnNumber <= 0
     */
    Token(ArithmeticOperatorLexeme aol, int lineNum, int columnNum)
    {
        if (aol == null)
            throw new IllegalArgumentException ("null ArithmeticOperatorLexeme");
        if (lineNum <= 0)
            throw new IllegalArgumentException ("invalid row number argument");
        if (columnNum <= 0)
            throw new IllegalArgumentException ("invalid column number argument");
        this.aol = aol;
        this.lineNum = lineNum;
        this.columnNum = columnNum;
    }
    /**
     * precondition: ID is not null, tokenrowNumber > 0, tokencolumnNumber > 0
     * postcondition: Token is created
     * @param ID
     * @param lineNum
     * @param columnNum
     * @throws IllegalArgumentException if ID is null, rowNumber <= 0, or columnNumber <= 0
     */
    Token(Character ID, int lineNum, int columnNum)
    {
        if (ID == null)
            throw new IllegalArgumentException ("null ID");
        if (lineNum <= 0)
            throw new IllegalArgumentException ("invalid row number argument");
        if (columnNum <= 0)
            throw new IllegalArgumentException ("invalid column number argument");
        this.kwl=globals.KeywordLexeme.ID;
        this.ID=ID;
        this.lineNum = lineNum;
        this.columnNum = columnNum;
    }
    /**
     * precondition: kwl is not null, tokenrowNumber > 0, tokencolumnNumber > 0
     * postcondition: Token is created
     * @param kwl
     * @param lineNum
     * @param columnNum
     * @throws IllegalArgumentException if kwl is null, rowNumber <= 0, or columnNumber <= 0
     */
    Token(KeywordLexeme kwl, int lineNum, int columnNum)
    {
        if (kwl == null)
            throw new IllegalArgumentException ("null KeywordLexeme");
        if (lineNum <= 0)
            throw new IllegalArgumentException ("invalid row number argument");
        if (columnNum <= 0)
            throw new IllegalArgumentException ("invalid column number argument");
        this.kwl=kwl;
        this.lineNum = lineNum;
        this.columnNum = columnNum;
    }
    /**
     * precondition: litInt is not null, tokenrowNumber > 0, tokencolumnNumber > 0
     * postcondition: Token is created
     * @param litInt
     * @param lineNum
     * @param columnNum
     * @throws IllegalArgumentException if litInt is null, rowNumber <= 0, or columnNumber <= 0
     */
    Token(Integer litInt, int lineNum, int columnNum)
    {
        if (litInt == null)
            throw new IllegalArgumentException ("null LiteralInteger");
        if (lineNum <= 0)
            throw new IllegalArgumentException ("invalid row number argument");
        if (columnNum <= 0)
            throw new IllegalArgumentException ("invalid column number argument");
        this.litInt=litInt;
        this.lineNum = lineNum;
        this.columnNum = columnNum;
    }
    /**
     * precondition: rol is not null, tokenrowNumber > 0, tokencolumnNumber > 0
     * postcondition: Token is created
     * @param rol
     * @param lineNum
     * @param columnNum
     * @throws IllegalArgumentException if rol is null, rowNumber <= 0, or columnNumber <= 0
     */
    Token(RelationalOperatorLexeme rol, int lineNum, int columnNum)
    {
        if (rol == null)
            throw new IllegalArgumentException ("null RelationalOperatorLexeme");
        if (lineNum <= 0)
            throw new IllegalArgumentException ("invalid row number argument");
        if (columnNum <= 0)
            throw new IllegalArgumentException ("invalid column number argument");
        this.rol=rol;
        this.lineNum = lineNum;
        this.columnNum = columnNum;
    }
    /**
     * @return aol
     * @throws IllegalArgumentException if aol is null
     */
    public ArithmeticOperatorLexeme getArithmeticOperator()
    {
        if(!isArithmeticOperator())
            throw new IllegalArgumentException ("null ArithmeticOperatorLexeme");
        return aol;
    }
    /**
     * @return ID
     * @throws IllegalArgumentException if ID is null
     */
    public Character getID()
    {
        if(!isID())
            throw new IllegalArgumentException ("null ID");
        return ID;
    }
    /**
     * @return kwl
     * @throws IllegalArgumentException if kwl is null
     */
    public KeywordLexeme getKeyword()
    {
        if(!isKeyword())
            throw new IllegalArgumentException ("null KeywordLexeme");
        return kwl;
    }
    /**
     * @return litInt
     * @throws IllegalArgumentException if litInt is null
     */
    public int getLiteralInteger()
    {
        if(!isLiteralInteger())
            throw new IllegalArgumentException ("null LiteralInteger");
        return litInt;
    }
    /**
     * @return rol
     * @throws IllegalArgumentException if rol is null
     */
    public RelationalOperatorLexeme getRelationalOperator()
    {
        if(!isRelationalOperator())
            throw new IllegalArgumentException ("null RelationalOperatorLexeme");
        return rol;
    }
    /**
     * @return true if token is ArithmeticOperator 
     */
    public boolean isArithmeticOperator()
    {
        return aol!=null;
    }
    /**
     * @return true if token is ID
     */
    public boolean isID()
    {
        return ID!=null;
    }
    /**
     * @return true if token is Keyword
     */
    public boolean isKeyword()
    {
        return kwl!=null;
    }
    /**
     * @return true if token is LiteralInteger
     */
    public boolean isLiteralInteger()
    {
        return litInt!=null;
    }
    /**
     * @return true if token is RelationalOperator
     */
    public boolean isRelationalOperator()
    {
        return rol!=null;
    }
    public int getLineNumber()
    {
        return lineNum;
    }
    public int getColumnNumber()
    {
        return columnNum;
    }
}

