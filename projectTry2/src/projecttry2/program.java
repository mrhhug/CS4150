package projecttry2;

import java.util.Queue;

public final class program
{
    Queue<token> tokenList;
    
    program(tokenizer tokenizer) throws Nodefkeywordexception, Noendkeywordexception, AssignemntOperatorExpectedException, LiteralIntegerExpectedException, idExpectedException
    {
        tokenList = tokenizer.getQueue();
        doit();
    }
    void doit() throws Nodefkeywordexception, Noendkeywordexception, AssignemntOperatorExpectedException, idExpectedException, LiteralIntegerExpectedException
    {
        token t =tokenList.poll();
        if(!keyword.Def(t.tokentype()))
            throw new Nodefkeywordexception(t);
        
        new code_block().passtokenList(tokenList);
        
        t =tokenList.poll();
        if(!keyword.End(t.tokentype()))
            throw new Noendkeywordexception(t);
    }
    
}
