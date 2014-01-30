package other;

import tokenz.Token;
import static tokenz.Arithmetic_Operator.*;

public class expression extends code_block
{
    Token t;
    expression e;
    expression e2;
    
    expression() throws ExpressionExpectedException
    {
        t = tokenList.poll();
        if(t.r!=null)
        {
            e = new expression();
            e2 = new expression();
        }
    }
    Integer evaluate() throws UndefinedVariableException, DivideByZeroException
    {
        int returnme;
        if(t.li != null)
            returnme = t.li;
        else if(t.id != null)
            returnme = mem.get(t);
        else
            returnme = evaluate(t, e, e2);
        return returnme;       
    }
    static Integer evaluate(Token t, expression e, expression e2) throws UndefinedVariableException, DivideByZeroException
    {
        Integer i = null;
        switch(t.r)
        {
            case ADD :
                i = e.evaluate() + e2.evaluate();
                break;
            case SUB :
                i = e.evaluate() - e2.evaluate();
                break;
            case MUL :
                i = e.evaluate() * e2.evaluate();
                break;
            case DIV :
                if(e2.evaluate()==0)
                    throw new DivideByZeroException(t);
                i = e.evaluate() - e2.evaluate();
                break;
        }
        return i;
    }
}
