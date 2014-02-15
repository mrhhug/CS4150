/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package globals;

public enum ArithmeticOperatorLexeme implements Lexeme
{
    ADD, SUB, MUL, DIV;
    
    public static ArithmeticOperatorLexeme promoteLexeme(Lexeme lexeme)
    {
        for (ArithmeticOperatorLexeme aolexeme : ArithmeticOperatorLexeme.values())
            if (aolexeme.toString().compareTo(lexeme.toString())==0)
                return aolexeme;
        return null;
    }
}