package other;

import java.util.LinkedList;
import java.util.Queue;
import static other.if_statement.iselse;
import static other.if_statement.isthen;
import static other.program.isendkeyword;
import static tokenz.Key_word.DO;
import tokenz.Keyword;
import tokenz.Token;

class while_statement extends code_block 
{   
    private final boolean_expresion b;
    private code_block cb;
    
    while_statement() throws AssignemntOperatorExpectedException, LiteralIntegerExpectedException, idExpectedException, StatementExpectedException, ExpressionExpectedException, DivideByZeroException, RedRover, UndefinedVariableException, RelationalOperatorExpectedException, Nothenkeywordexception, Noelsekeywordexception, Noendkeywordexception
    {
        b = new boolean_expresion(super.tokenList.poll());
        Token t;
        
        Queue<Token> tokenList1 = new LinkedList<>();
        while(!isdo(super.tokenList.peek()))
            tokenList1.add(super.tokenList.poll());
        super.tokenList.poll(); // remove do
        cb = new code_block();
        cb.passtokenList(tokenList1);
        
        t = tokenList1.poll();
        if(!isendkeyword(t))
            throw new Noendkeywordexception(t);
        trigger();
    }
    protected void trigger() throws AssignemntOperatorExpectedException, LiteralIntegerExpectedException, idExpectedException, StatementExpectedException, DivideByZeroException, RedRover, UndefinedVariableException
    {
        while(b.evaluate())
            cb.trigger();
    }
    static boolean isdo(Keyword k)
    {
        return k.getKeyword()==DO;
    }
    static boolean isdo(Token t)
    {
        return false;
    }
}