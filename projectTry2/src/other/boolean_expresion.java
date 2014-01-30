package other;

import tokenz.RelationalOperator;
import tokenz.Token;

public class boolean_expresion extends code_block
{
    private RelationalOperator r;
    private expression e;
    private expression e2;
    
    boolean_expresion(Token t) throws RelationalOperatorExpectedException, AssignemntOperatorExpectedException, LiteralIntegerExpectedException, idExpectedException, StatementExpectedException
    {
        throw new RelationalOperatorExpectedException(t);
    }
    boolean_expresion(RelationalOperator r) throws AssignemntOperatorExpectedException, LiteralIntegerExpectedException, idExpectedException, StatementExpectedException, RelationalOperatorExpectedException, ExpressionExpectedException
    {
        this.r = r ;
        e = new expression(tokenList.poll());
        e2 = new expression(tokenList.poll());        
    }
    public boolean evaluate() throws DivideByZeroException, RedRover, UndefinedVariableException
    {
        boolean value;
            switch (r.getRelational_Operator())
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
                        throw new RedRover(r.getlineNumber(), r.getcolNumber());
            }
        return value; 
    }
}
