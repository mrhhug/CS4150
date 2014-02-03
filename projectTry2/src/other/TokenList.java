package other;

import java.util.LinkedList;
import java.util.List;
import tokenz.Token;

public class TokenList
{
    private final List<Token> tl;
    
    public TokenList()
    {
        tl = new LinkedList();
    }
    public void add(Token t)
    {
        tl.add(t);
    }
    public Token getNextToken()
    {
        if (tl.isEmpty())
            throw new RuntimeException ("no more tokens");
        return tl.remove(0);
    }
    public Token getLookaheadToken()
    {
        if (tl.isEmpty())
                throw new RuntimeException ("no more tokens");
        return tl.get(0);
    }
}
