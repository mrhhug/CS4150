package project;

class program
{
    private int exit_code;
    private boolean code_block_is_open;
    private code_block cdblk;
    
    public program()
    {
        code_block_is_open = false;
        exit_code = 1;
    }
    public int recepticle(String str,int tokenNum) throws arithmetic_operator_expected_exception, Nodefkeywordexception, Noendkeywordexception, StatementExpectedException, aWildKeystrokeAppeared, UndefinedVariableException, AssignemntOperatorExpectedException
    {
        if(code_block_is_open)
            code_block_is_open=!cdblk.recepticle(str, tokenNum);
        else
        {
            if(str.equals("def"))
            {
                code_block_is_open = true;
                cdblk=new code_block();
            }
            else if(cdblk.getlook_ahead().equals("end"))
            {
                exit_code = 0;
                cdblk = null;
            }
            else
            {
                assert (!str.equals("def") || !str.equals("end"));
                throw new aWildKeystrokeAppeared(tokenNum);
            }
        }
        return exit_code;
    }
}
