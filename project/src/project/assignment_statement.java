package project;

class assignment_statement extends statement
{
    String letter;
    int statementcount;
    expression exp;
    boolean betterBeAnEqualSign;
    
    public assignment_statement(String token)
    {
        assert(lexAnal.id(token));
        letter = token;
        betterBeAnEqualSign =true;
    }
    public boolean recepticle(String token,int tokenNum) throws AssignemntOperatorExpectedException, arithmetic_operator_expected_exception, UndefinedVariableException
    {
        boolean selfDestruct = false;
        if(betterBeAnEqualSign)
        {
            betterBeAnEqualSign = false;
            if(!lexAnal.assignment_operator(token))
                throw new AssignemntOperatorExpectedException(tokenNum);
        }
        else
        {
            if(exp.recepticle(token,tokenNum))
            {
                ddr.setIdentifier(letter,exp.getInt());
                letter = null;
                exp = null;
                selfDestruct = true;
            }
        }
        return selfDestruct;
    }
}
