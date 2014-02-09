package other;

import java.util.LinkedList;
import java.util.Queue;
import static tokenz.Keyword.*;

class statement extends code_block
{
    statement()
    {
        
    }
    statement(Token t) throws AssignemntOperatorExpectedException, LiteralIntegerExpectedException, idExpectedException, StatementExpectedException, DivideByZeroException, RedRover, UndefinedVariableException, ExpressionExpectedException, RelationalOperatorExpectedException, Nothenkeywordexception, Noelsekeywordexception, Noendkeywordexception
    {
        int i = 0;
        tl.getLookaheadToken();
        ////get rid of me
        Token r = tl.getNextToken();
        
        if(t.id!=null)
            new assignment_statement(t);
        else if(t.k==PUTS)
            new print_statement();
        else if(t.k==WHILE)
            new while_statement();
        else if(t.k==IF)
            new if_statement();
        //else if(t.k==UNTIL)
          //  new until_statement();
        else
            throw new StatementExpectedException(t);
    }
}
class assignment_statement extends code_block
{
    assignment_statement(Token t) throws AssignemntOperatorExpectedException, LiteralIntegerExpectedException, idExpectedException, StatementExpectedException, DivideByZeroException, RedRover, UndefinedVariableException, ExpressionExpectedException
    {
        Token tt = tl.getNextToken();
        if(tt.k!=ASSIGN)
            throw new AssignemntOperatorExpectedException(t);
        
        expression e = new expression();
        mem.set(t, e.evaluate());
    }
}
class print_statement extends code_block 
{   
    print_statement() throws AssignemntOperatorExpectedException, LiteralIntegerExpectedException, idExpectedException, StatementExpectedException, ExpressionExpectedException, DivideByZeroException, RedRover, UndefinedVariableException
    {
        expression e = new expression();
        // ruby appends the newline to puts
        System.out.println(e.evaluate());
    }
}
class while_statement extends code_block 
{   
    private final boolean_expresion b;
    private code_block cb;
    
    while_statement() throws AssignemntOperatorExpectedException, LiteralIntegerExpectedException, idExpectedException, StatementExpectedException, ExpressionExpectedException, DivideByZeroException, RedRover, UndefinedVariableException, RelationalOperatorExpectedException, Nothenkeywordexception, Noelsekeywordexception, Noendkeywordexception
    {
        b = new boolean_expresion();
        Token t;
        
        Queue<Token> tokenList1 = new LinkedList<>();
        while(tl.getLookaheadToken().k!=DO)
            tokenList1.add(tl.getNextToken());
        tl.getNextToken(); // remove do
        cb = new code_block();
        //cb.passtokenList(tokenList1);
        
        t = tokenList1.poll();
        if(t.k!=END)
            throw new Noendkeywordexception(t);
        this.trigger();
    }
    void trigger()
    {
        
    }
}
class if_statement extends code_block
{
    boolean_expresion b;
    code_block cb;
    code_block cb2;
    
    if_statement() throws AssignemntOperatorExpectedException, LiteralIntegerExpectedException, idExpectedException, StatementExpectedException, RelationalOperatorExpectedException, Nothenkeywordexception, Noelsekeywordexception, Noendkeywordexception, RedRover, DivideByZeroException, UndefinedVariableException, ExpressionExpectedException
    {
        b = new boolean_expresion();
        Token t;
        
        t = tl.getNextToken();
        if(t.k!=THEN)
            throw new Nothenkeywordexception(t);
        
        cb = new code_block();
        System.arraycopy(super.mem, 0, cb.mem, 0, 51);
        //cb.passtokenList(super.tokenList);
        
        t = tl.getNextToken();
        if(t.k!=ELSE)
            throw new Noelsekeywordexception(t);
             
        cb2 = new code_block();
        System.arraycopy(super.mem, 0, cb2.mem, 0, 51);
        //cb2.passtokenList(super.tokenList);
        
        t = tl.getNextToken();
        if(t.k!=END)
            throw new Noendkeywordexception(t);
        this.trigger();
    }
    void trigger() throws AssignemntOperatorExpectedException, LiteralIntegerExpectedException, idExpectedException, StatementExpectedException, DivideByZeroException, RedRover, UndefinedVariableException, ExpressionExpectedException, RelationalOperatorExpectedException, Nothenkeywordexception, Noelsekeywordexception, Noendkeywordexception
    {
        if(b.evaluate())
            cb.trigger();
        else
            cb2.trigger();
    }
}