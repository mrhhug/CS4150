package project;

public class statement extends code_block
{
    statement stamt;
    
    public boolean recepticle(String token, int tokenNum) throws arithmetic_operator_expected_exception, StatementExpectedException, UndefinedVariableException, AssignemntOperatorExpectedException
    {
        boolean selfDestruct = false;
        if(stamt == null)
        {
            if(keyword.BeginNewStatement(token))
                createNewStatement(token);
            else
                throw new StatementExpectedException(tokenNum);
        }
        else
            selfDestruct = stamt.recepticle(token, tokenNum);
        return selfDestruct;
    }
    /**
     * precondition : no statement is initiated
     * @param token ; must be a valid beginning statement token
     * post condition : new statement created
     */
    private void createNewStatement(String token)
    {
        assert (stamt == null);
        assert (keyword.BeginNewStatement(token));
        if(keyword.If(token))
            stamt = new if_statement();
        else if(keyword.While(token))
            stamt = new while_statement();
        else if(keyword.Puts(token))
            stamt = new print_statement();
        else if(keyword.Until(token))
            stamt = new until_statement();
        else if(lexAnal.id(token))
        // just pass the variable letter right away, every other case is gonna throw out the keyword
            stamt = new assignment_statement(token);
    }
}
