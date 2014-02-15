/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package lexicalanalyzer;

import globals.Lexeme;

public class Token
{
    private char Char;
    private int litInt;
    private final Lexeme lexeme;
    private final int lineNum;
    private final int columnNum;
    
    Token(Lexeme lx, int lineNum, int columnNum)
    {
        this.lexeme = lx;
        this.lineNum = lineNum;
        this.columnNum = columnNum;
    }
    Token(char Char, int lineNum, int columnNum)
    {
        this.Char=Char;
        this.lexeme=globals.KeywordLexeme.ID;
        this.lineNum = lineNum;
        this.columnNum = columnNum;
    }
    Token(int litInt, int lineNum, int columnNum)
    {
        this.litInt=litInt;
        this.lexeme=globals.KeywordLexeme.LI;
        this.lineNum = lineNum;
        this.columnNum = columnNum;
    }
    public Character getCharacter()
    {
        return Char;
    }
    public int getLiteralInteger()
    {
        return litInt;
    }
    public Lexeme getLexeme()
    {
        return lexeme;
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

