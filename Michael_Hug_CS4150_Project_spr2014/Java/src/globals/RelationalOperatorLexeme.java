/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package globals;

public enum RelationalOperatorLexeme implements Lexeme
{
    LE, LT, GE, GT, EQ, NE;
    
    public static RelationalOperatorLexeme promoteLexeme(Lexeme lexeme)
    {
        for (RelationalOperatorLexeme rolexeme : RelationalOperatorLexeme.values())
            if (rolexeme.toString().compareTo(lexeme.toString())==0)
                return rolexeme;
        return null;
    }
}