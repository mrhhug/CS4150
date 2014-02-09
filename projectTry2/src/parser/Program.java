package parser;

import lexicalanalyzer.Token;
import static_classes.tl;
import exceptions.RuntimeError;

class Program
{
   
    Program() throws RuntimeError
    {
        Token t = tl.pop();
        if(t.getKeyword()!=enumerated_lists.Keyword.DEF)
            new RuntimeError("def keyword expected",t);
        
        code_block cb= new code_block();
        
        t = tl.pop();
        if(t.getKeyword()!=enumerated_lists.Keyword.END)
            new RuntimeError("end keyword expected",t);
        cb.evaluate();
    }
}
