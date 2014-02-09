package parser;

import lexicalanalyzer.Token;
import static_classes.tl;
import static enumerated_lists.Arithmetic_Operator.*;
import static_classes.memory;
import exceptions.RuntimeError;

class expresion
{
    Token t;
    expresion e0;
    expresion e1;
    
    expresion()
    {
        t = tl.pop();
        if(t.getCharacter()==null && t.getInteger()==null)
        {
            e0 = new expresion();
            e1 = new expresion();
        }
    }
    Integer evaluate() throws RuntimeError
    {
        if(t.getInteger()!=null)
            return t.getInteger();
        else if (t.getCharacter()!=null)
            return memory.get(t);
        else if (t.getArithmetic_Operator()==ADD)
            return e0.evaluate() + e1.evaluate();
        else if (t.getArithmetic_Operator()==SUB)
            return e0.evaluate() - e1.evaluate();
        else if (t.getArithmetic_Operator()==MUL)
            return e0.evaluate() * e1.evaluate();
        else if (t.getArithmetic_Operator()==DIV)
            return e0.evaluate() / e1.evaluate();
        else
            throw new RuntimeError("arithmatic operato, id, or literal integer expected",t);
    }
}
