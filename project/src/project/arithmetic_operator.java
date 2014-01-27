package project;

public class arithmetic_operator extends expression
{
    private final String operator;
    
    public arithmetic_operator(String token, int tokenNum) throws arithmetic_operator_expected_exception
    {
        if(lexAnal.add_operator(token) || lexAnal.sub_operator(token) || lexAnal.mult_operator(token) || lexAnal.div_operator(token))
            operator=token;
        else
            throw new arithmetic_operator_expected_exception(tokenNum);
    }
}
