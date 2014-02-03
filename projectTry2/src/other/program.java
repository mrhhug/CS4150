package other;

import static tokenz.Keyword.*;
import tokenz.Token;



public final class program
{
    TokenList tl;
    
    program(tokenizer tokenizer) throws Noendkeywordexception, Nodefkeywordexception, AssignemntOperatorExpectedException, LiteralIntegerExpectedException, idExpectedException, StatementExpectedException, DivideByZeroException, RedRover, UndefinedVariableException, ExpressionExpectedException, RelationalOperatorExpectedException, Nothenkeywordexception, Noelsekeywordexception
    {
        tl = tokenizer.getTokenList();
        doit();
    }
    void doit() throws Noendkeywordexception, Nodefkeywordexception, AssignemntOperatorExpectedException, LiteralIntegerExpectedException, idExpectedException, StatementExpectedException, DivideByZeroException, RedRover, UndefinedVariableException, ExpressionExpectedException, RelationalOperatorExpectedException, Nothenkeywordexception, Noelsekeywordexception
    {
        Token t;
        //obvious place to get stuck
        while(tl.getLookaheadToken().k!=EOF) // becasue we can have 2 programs in one file???
        {
            t = tl.getNextToken();
            if(t.k!=DEF)
                throw new Nodefkeywordexception(t);
            int endcount = 0;
            code_block cb = new code_block();
            while(true)
            {
                if(tl.getLookaheadToken().k==IF || tl.getLookaheadToken().k==WHILE || tl.getLookaheadToken().k==UNTIL)
                    endcount++;
                if(tl.getLookaheadToken().k==END)
                {
                    if(endcount==0)
                        break; ///clean this up, we should only have one exit point
                    else
                        endcount--;
                }
                cb.tl.add(tl.getNextToken());
            }
            t = tl.getNextToken();
            if(t.k!=END)
                throw new Noendkeywordexception(t);
            cb.trigger();
        }
    }    
}
