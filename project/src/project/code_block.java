package project;

class code_block
{
    private statement stmt;
    private String look_ahead;
    //variables are local to the code block inside the program
    memory ddr;
    
    code_block()
    {
        ddr = new memory();
    }
    public boolean recepticle(String token,int tokenNum) throws arithmetic_operator_expected_exception, StatementExpectedException, UndefinedVariableException, AssignemntOperatorExpectedException
    {
        boolean selfDestruct = false;
        if(look_ahead == null)
        {
            look_ahead = token;
        }
        else 
        {
            if(stmt==null)
                stmt = new statement();
            if (stmt.recepticle(look_ahead, tokenNum))
                {selfDestruct =true; stmt = null;}
            look_ahead = token;
        }
        return selfDestruct && !keyword.BeginNewStatement(token);
    }
    public String getlook_ahead()
    {
        return look_ahead;
    }
}
