package other;

import java.util.LinkedList;
import java.util.Queue;
import static other.program.isendkeyword;
import static tokenz.Key_word.ELSE;
import static tokenz.Key_word.THEN;
import tokenz.Keyword;
import tokenz.Token;

class if_statement extends code_block
{
    boolean_expresion b;
    code_block cb;
    code_block cb2;
    
    if_statement() throws AssignemntOperatorExpectedException, LiteralIntegerExpectedException, idExpectedException, StatementExpectedException, RelationalOperatorExpectedException, Nothenkeywordexception, Noelsekeywordexception, Noendkeywordexception, RedRover, DivideByZeroException, UndefinedVariableException
    {
        b = new boolean_expresion(super.tokenList.poll());
        Token t;
        
        t = super.tokenList.poll();
        if(!isthen(t))
            throw new Nothenkeywordexception(t);
        
        Queue<Token> tokenList1 = new LinkedList<>();
        while(!iselse(super.tokenList.peek()))
            tokenList1.add(super.tokenList.poll());
        cb = new code_block();
        cb.passtokenList(tokenList1);
        
        t = tokenList1.poll();
        if(!iselse(t))
            throw new Noelsekeywordexception(t);
             
        Queue<Token> tokenList2 = new LinkedList<>();
        while(!iselse(super.tokenList.peek()))
            tokenList2.add(super.tokenList.poll());
        cb2 = new code_block();
        cb2.passtokenList(tokenList2);
        
        t = tokenList1.poll();
        if(!isendkeyword(t))
            throw new Noendkeywordexception(t);
        trigger();
    }
    void trigger() throws AssignemntOperatorExpectedException, LiteralIntegerExpectedException, idExpectedException, StatementExpectedException, DivideByZeroException, RedRover, UndefinedVariableException
    {
        if(b.evaluate())
            cb.trigger();
        else
            cb2.trigger();
    }
    static boolean isthen(Keyword k)
    {
        return k.getKeyword()==THEN;
        
    }
    static boolean isthen(Token t)
    {
        return false;
    }
    static boolean iselse(Keyword k)
    {
        return k.getKeyword()==ELSE;
        
    }
    static boolean iselse(Token t)
    {
        return false;
    }
}