/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package globals;

import lexicalanalyzer.Token;

public class tl
{
    private static final java.util.List<Token> TokenList = new java.util.LinkedList<>();
    
    /**
     * adds token to tokenlist
     * @param t 
     */
    public static void add(Token t)
    {
        TokenList.add(t);
    }
    /**
     * returns zeroith token on tokenlist removing token
     * @return zeroith item on tokenlist
     */
    public static Token pop()
    {
        if (!moreTokens())
                throw new RuntimeException ("no more tokens");
        return TokenList.remove(0);
    }
    /**
     * returns zeroith token on tokenlist without removing token
     * @return zeroith item on tokenlist
     */
    public static Token peek()
    {
        if (!moreTokens())
                throw new RuntimeException ("no more tokens");
        return TokenList.get(0);
    }
    /**
     * @return true only it tokenlist has more tokens
     */
    public static boolean moreTokens ()
    {
        return !TokenList.isEmpty();
    }
}
