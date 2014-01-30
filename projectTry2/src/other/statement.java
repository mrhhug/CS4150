package other;

import static tokenz.Keyword.ASSIGN;
import static tokenz.Keyword.IF;
import static tokenz.Keyword.PUTS;
import static tokenz.Keyword.UNTIL;
import static tokenz.Keyword.WHILE;
import tokenz.Token;



class statement extends code_block
{
    statement(Token t) throws AssignemntOperatorExpectedException, LiteralIntegerExpectedException, idExpectedException, StatementExpectedException
    {
        if(t.id!=null)
            new assignment_statement(t);
        else if(t.k==PUTS)
            new print_statement();
        else if(t.k==WHILE)
            new while_statement();
        else if(t.k==IF)
            new if_statement();
        else if(t.k==UNTIL)
            new until_statement();
        else
            throw new StatementExpectedException(t);
    }
class assignment_statement extends code_block
{
    assignment_statement(Token t) throws AssignemntOperatorExpectedException, LiteralIntegerExpectedException, idExpectedException, StatementExpectedException, DivideByZeroException, RedRover, UndefinedVariableException
    {
        Token tt = tokenList.poll();
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