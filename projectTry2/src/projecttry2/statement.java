package projecttry2;

public class statement extends code_block
{
    statement() throws AssignemntOperatorExpectedException, LiteralIntegerExpectedException, idExpectedException
    {
        createNewStatement();
    }
    private void createNewStatement() throws AssignemntOperatorExpectedException, LiteralIntegerExpectedException, idExpectedException
    {
        token t =tokenList.poll();
        if(lexAnal.id(t.tokentype()))
            new assignment_statement(t);
        else if(keyword.Puts(t.tokentype()))
            new print_statement();    
        else if(keyword.While(t.tokentype()))
            new while_statement();
        else if(keyword.If(t.tokentype()))
            new if_statement();
        else if(keyword.Until(t.tokentype()))
            new until_statement();
    }
}

class assignment_statement extends statement
{  
    public assignment_statement(token t) throws AssignemntOperatorExpectedException, LiteralIntegerExpectedException, idExpectedException
    {
        token u =tokenList.poll();
        if(lexAnal.assignment_operator(u.tokentype()))
            throw new AssignemntOperatorExpectedException(u);
        NVRAM.setIdentifier(t, u);
    }
}
class print_statement extends statement 
{   
    print_statement() throws AssignemntOperatorExpectedException, LiteralIntegerExpectedException, idExpectedException
    {
        // ruby appends the newline to puts
        System.out.println(new expression);
    }
}