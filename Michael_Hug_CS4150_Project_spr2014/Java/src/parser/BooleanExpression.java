/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package parser;

import globals.RelationalOperatorLexeme;

class BooleanExpression
{
    RelationalOperatorLexeme relationalOperator;
    Expression expr1;
    Expression expr2;
    
    BooleanExpression(RelationalOperatorLexeme relationOperator, Expression expr1, Expression expr2)
    {
        this.relationalOperator=relationOperator;
        this.expr1=expr1;
        this.expr2=expr2;
    }
    boolean evaluate() throws exceptions.UndefinedVariable
    {
        switch (relationalOperator)
        {
            case LE:  
                return expr1.evaluate() <= expr2.evaluate();
            case LT:  
                return expr1.evaluate() < expr2.evaluate();
            case GE:  
                return expr1.evaluate() >= expr2.evaluate();
            case GT:  
                return expr1.evaluate() > expr2.evaluate();
            case EQ:  
                return expr1.evaluate() == expr2.evaluate();
            //case NE:  
              //  return e0.evaluate() != e1.evaluate();
        }
        return expr1.evaluate() != expr2.evaluate();
    }
}
