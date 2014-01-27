package project;
        
public class expression extends statement
{
    private boolean selfDestruct;
    private int evaluatedExpresion;
    arithmetic_operator operator;
    
    boolean expression()
    {
        selfDestruct = false;
        return false;
    }
    //this should probobly be overloaded somehow
    boolean expresion(String token,int tokenNum)
    {
        boolean returnme = false;
        if(lexAnal.literal_integer(token))
        {
            evaluatedExpresion = Integer.parseInt(token);
            returnme = true;
        }
        else if (lexAnal.id(token))
        {
            evaluatedExpresion = ddr.getIdentifier(token, tokenNum);
            returnme = true;
        }
        return returnme;
    }    
    public boolean recepticle(String token, int tokenNum) throws arithmetic_operator_expected_exception, UndefinedVariableException 
    {
        examineToken(token, tokenNum);
        return selfDestruct;
    }

    void examineToken(String token, int tokenNum) throws arithmetic_operator_expected_exception, UndefinedVariableException
    {
        //do we have an arithmatic operator, expression, id, or literal integer
        if(operator == null)
        {
            if(lexAnal.literal_integer(token))
            {
                selfDestruct=true;
                evaluatedExpresion=Integer.parseInt(token);
            }
            else if (lexAnal.id(token))
            {
                selfDestruct=true;
                evaluatedExpresion=ddr.getIdentifier(token, tokenNum);
            }
            else if(lexAnal(token))
                operator = new arithmetic_operator(token,tokenNum);
        }
        else
        {
            if(lexAnal.literal_integer(token))
            {
                selfDestruct=true;
                evaluatedExpresion=Integer.parseInt(token);
            }
            else if (lexAnal.id(token))
            {
                selfDestruct=true;
                evaluatedExpresion=ddr.getIdentifier(token, tokenNum);
            }
        }
    }
    private void evaluate(arithmetic_operator operator,expression operand0, expression operand1)
    {
        if(lexAnal.add_operator(null))
            literal_integer=operand0.literal_integer+operand1.literal_integer;
        else if(operator.equals('-'))
            literal_integer=operand0.literal_integer-operand1.literal_integer;
        else if(operator.equals('*'))
            literal_integer=operand0.literal_integer*operand1.literal_integer;
        else if(operator.equals('/'))
            literal_integer=operand0.literal_integer/operand1.literal_integer;
    }
    @Override
    public  String toString()
    {
        return Integer.toString(literal_integer);
    }
    public int getInt()
    {
        return evaluatedExpresion;
    }
    private int 
    
}
