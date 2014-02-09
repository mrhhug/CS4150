package parser;

import lexicalanalyzer.Token;
import static_classes.tl;
import exceptions.RuntimeError;

class boolean_expression
{
    Token t;
    expresion e0;
    expresion e1;
    
    boolean_expression() throws RuntimeError
    {
        t=tl.pop();
        if(t.getRelation_Operator()==null)
            throw new RuntimeError("relational operator expected",t);
        e0= new expresion();
        e1 = new expresion();
    }
    boolean evaluate() throws RuntimeError
    {
        switch (t.getRelation_Operator())
        {
            case LE:  
                return e0.evaluate() <= e1.evaluate();
            case LT:  
                return e0.evaluate() < e1.evaluate();
            case GE:  
                return e0.evaluate() >= e1.evaluate();
            case GT:  
                return e0.evaluate() > e1.evaluate();
            case EQ:  
                return e0.evaluate() == e1.evaluate();
            case NE:  
                return e0.evaluate() != e1.evaluate();
        }
        throw new RuntimeError("relational operator expected",t);
    }
}
