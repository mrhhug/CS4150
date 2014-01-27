package project;

class print_statement extends statement
{   
    expression exp;
    
    print_statement()
    {
        exp = new expression();
    }
    public boolean recepticle(String token,int tokenNum) throws arithmetic_operator_expected_exception, UndefinedVariableException
    {
        // ruby appends the newline to puts
        if(exp.recepticle(token,tokenNum))
            System.out.println(exp);
        return true;
    }
}
