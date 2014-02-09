package other;

import static goodtry.ArithmeticOperatorEnum.*;

public class Parser 
{
    TokenList tl;
    program p;
    
    public Parser (tokenizer tokenizer)
    {
        tl = tokenizer.getTokenList();
        while(!tl.isEmpty())
            beginprogram();
    }
    private program beginprogram()
    {
        p = new program(this);
        
        
        return p;
    }
    public Token get()
    {
        return tl.getNextToken();
    }
    
}
