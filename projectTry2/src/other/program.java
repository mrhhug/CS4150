package other;

import java.util.Queue;
import static tokenz.Keyword.DEF;
import static tokenz.Keyword.END;
import tokenz.Token;



public final class program
{
    Queue<Token> tokenList;
    
    program(tokenizer tokenizer) throws Noendkeywordexception, Nodefkeywordexception, AssignemntOperatorExpectedException, LiteralIntegerExpectedException, idExpectedException, StatementExpectedException, DivideByZeroException, RedRover, UndefinedVariableException
    {
        tokenList = tokenizer.getQueue();
        doit();
    }
    void doit() throws Noendkeywordexception, Nodefkeywordexception, AssignemntOperatorExpectedException, LiteralIntegerExpectedException, idExpectedException, StatementExpectedException, DivideByZeroException, RedRover, UndefinedVariableException
    {
        Token t;
        t = tokenList.poll();
        if(t.k!=DEF)
            throw new Nodefkeywordexception(t);
        
        code_block cb = new code_block();
        cb.passtokenList(tokenList);
        cb.trigger();
        
        t = tokenList.poll();
        if(t.k!=END)
            throw new Noendkeywordexception(t);
    }    
}
