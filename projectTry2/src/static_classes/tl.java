package static_classes;

import lexicalanalyzer.Token;

public class tl
{
    public static java.util.List<Token> TokenList = new java.util.LinkedList<>();
    
    public static void add(Token t)
    {
        TokenList.add(t);
    }
    public static Token pop()
    {
        if (!moreTokens())
                throw new RuntimeException ("no more tokens");
        return TokenList.remove(0);
    }
    public static Token peek()
    {
        if (!moreTokens())
                throw new RuntimeException ("no more tokens");
        return TokenList.get(0);
    }
    public static boolean moreTokens ()
    {
        return !TokenList.isEmpty();
    }
}
