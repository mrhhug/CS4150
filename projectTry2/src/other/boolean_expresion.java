package other;

import static tokenz.Relational_Operator.*;
import tokenz.Token;

public class boolean_expresion extends code_block
{
    private Token t;
    private expression e;
    private expression e2;
    
    boolean_expresion() throws RelationalOperatorExpectedException, ExpressionExpectedException
    {
        t = tokenList.poll();
        if(t.r==null)
            throw new RelationalOperatorExpectedException(t);
        e = new expression();
        e2 = new expression();
    }

    public boolean evaluate() throws UndefinedVariableException, DivideByZeroException, RedRover
    {
        boolean value;
        switch (t.r)
        {
            case LE:
                    value = e.evaluate() <= e2.evaluate();
                    break;
            case LT:
                    value = e.evaluate() < e2.evaluate();
                    break;
            case GE:
                    value = e.evaluate() >= e2.evaluate();
                    break;
            case GT:
                    value = e.evaluate() > e2.evaluate();
                    break;
            case EQ:
                    value = e.evaluate() == e2.evaluate();
                    break;
            case NE:
                    value = e.evaluate() != e2.evaluate();
                    break;
            default: 
                    throw new RedRover(t.lineNumber,t.colNumber);
        }
        return value; 
    }
}
