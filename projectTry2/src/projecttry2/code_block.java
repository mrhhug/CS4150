package projecttry2;

import java.util.Queue;

public class code_block
{
    Queue<token> tokenList;
    memory NVRAM;
    
    code_block() throws AssignemntOperatorExpectedException, LiteralIntegerExpectedException, idExpectedException
    {
        NVRAM = new memory();
        while(keyword.isStatement(tokenList.peek().tokentype()))
        {
            new statement();
        }
    }
    void passtokenList(Queue<token> tokenList)
    {
        this.tokenList=tokenList;
    }
}
