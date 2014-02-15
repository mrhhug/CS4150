/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package globals;

public enum KeywordLexeme implements Lexeme
{
    ASSIGN, EOF, DEF, END, IF, THEN, ELSE, WHILE, DO, PUTS, UNTIL, ID, LI;

    public static KeywordLexeme promoteLexeme(Lexeme lexeme)
    {
        for (KeywordLexeme klexeme : KeywordLexeme.values())
            if (klexeme.toString().compareTo(lexeme.toString())==0)
                return klexeme;
        return null;
    }
}