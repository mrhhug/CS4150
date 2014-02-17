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
    private ArithmeticOperatorLexeme arithmeticOperatorLexeme;
    private Character ID;
    private KeywordLexeme keywordLexeme;
    private Integer litInt;
    private RelationalOperatorLexeme relationalOperatorLexeme;
    private final int columnNum;
    private final int lineNum;
    
    /**
     * precondition: arithmeticOperatorLexeme is not null, tokenrowNumber > 0, tokencolumnNumber > 0
     * postcondition: Token is created
     * @param arithmeticOperatorLexeme
     * @param lineNum
     * @param columnNum
     * @throws IllegalArgumentException if arithmeticOperatorLexeme is null, rowNumber <= 0, or columnNumber <= 0
     */
    Token(ArithmeticOperatorLexeme arithmeticOperatorLexeme, int lineNum, int columnNum)
    {
        if (arithmeticOperatorLexeme == null)
            throw new IllegalArgumentException ("null ArithmeticOperatorLexeme");
        if (lineNum <= 0)
            throw new IllegalArgumentException ("invalid row number argument");
        if (columnNum <= 0)
            throw new IllegalArgumentException ("invalid column number argument");
        this.arithmeticOperatorLexeme = arithmeticOperatorLexeme;
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
        this.keywordLexeme=globals.KeywordLexeme.ID;
        this.ID=ID;
        this.lineNum = lineNum;
        this.columnNum = columnNum;
    }
    /**
     * precondition: keywordLexeme is not null, tokenrowNumber > 0, tokencolumnNumber > 0
     * postcondition: Token is created
     * @param keywordLexeme
     * @param lineNum
     * @param columnNum
     * @throws IllegalArgumentException if keywordLexeme is null, rowNumber <= 0, or columnNumber <= 0
     */
    Token(KeywordLexeme keywordLexeme, int lineNum, int columnNum)
    {
        if (keywordLexeme == null)
            throw new IllegalArgumentException ("null KeywordLexeme");
        if (lineNum <= 0)
            throw new IllegalArgumentException ("invalid row number argument");
        if (columnNum <= 0)
            throw new IllegalArgumentException ("invalid column number argument");
        this.keywordLexeme=keywordLexeme;
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
     * precondition: relationalOperatorLexeme is not null, tokenrowNumber > 0, tokencolumnNumber > 0
     * postcondition: Token is created
     * @param relationalOperatorLexeme
     * @param lineNum
     * @param columnNum
     * @throws IllegalArgumentException if relationalOperatorLexeme is null, rowNumber <= 0, or columnNumber <= 0
     */
    Token(RelationalOperatorLexeme relationalOperatorLexeme, int lineNum, int columnNum)
    {
        if (relationalOperatorLexeme == null)
            throw new IllegalArgumentException ("null RelationalOperatorLexeme");
        if (lineNum <= 0)
            throw new IllegalArgumentException ("invalid row number argument");
        if (columnNum <= 0)
            throw new IllegalArgumentException ("invalid column number argument");
        this.relationalOperatorLexeme=relationalOperatorLexeme;
        this.lineNum = lineNum;
        this.columnNum = columnNum;
    }
    /**
     * @return arithmeticOperatorLexeme
     * @throws IllegalArgumentException if arithmeticOperatorLexeme is null
     */
    public ArithmeticOperatorLexeme getArithmeticOperator()
    {
        if(!isArithmeticOperator())
            throw new IllegalArgumentException ("null ArithmeticOperatorLexeme");
        return arithmeticOperatorLexeme;
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
     * @return keywordLexeme
     * @throws IllegalArgumentException if keywordLexeme is null
     */
    public KeywordLexeme getKeyword()
    {
        if(!isKeyword())
            throw new IllegalArgumentException ("null KeywordLexeme");
        return keywordLexeme;
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
     * @return relationalOperatorLexeme
     * @throws IllegalArgumentException if relationalOperatorLexeme is null
     */
    public RelationalOperatorLexeme getRelationalOperator()
    {
        if(!isRelationalOperator())
            throw new IllegalArgumentException ("null RelationalOperatorLexeme");
        return relationalOperatorLexeme;
    }
    /**
     * @return true if token is ArithmeticOperator 
     */
    public boolean isArithmeticOperator()
    {
        return arithmeticOperatorLexeme!=null;
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
        return keywordLexeme!=null;
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
        return relationalOperatorLexeme!=null;
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

