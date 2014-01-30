package other;

import java.util.Queue;
import tokenz.Id;
import tokenz.Keyword;
import static tokenz.Keyword.IF;
import static tokenz.Keyword.PUTS;
import static tokenz.Keyword.UNTIL;
import static tokenz.Keyword.WHILE;
import tokenz.Token;

public class code_block
{
    Queue<Token> tokenList;
    memory mem;
    
    code_block() 
    {
        mem = new memory();  
    }
    void trigger() throws AssignemntOperatorExpectedException, LiteralIntegerExpectedException, idExpectedException, StatementExpectedException, DivideByZeroException, RedRover, UndefinedVariableException
    {
       Token t;
       t = tokenList.poll();
       while(t.id!=null || t.k==IF || t.k==WHILE || t.k==PUTS || t.k==UNTIL)
            new statement(tokenList.poll());
    }
    void passtokenList(Queue<Token> tokenList)
    {
        this.tokenList = tokenList;
    }
}
