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
    /**
     * preconditions: relationOperator is not null, expr1 is not null, expr2 is not null
     * postcondition: BooleanExpression is created
     * @param relationOperator
     * @param expr1
     * @param expr2
     */
    BooleanExpression(RelationalOperatorLexeme relationOperator, Expression expr1, Expression expr2)
    {
        if (relationOperator == null)
            throw new IllegalArgumentException ("null RelationalOperatorLexeme");
        if (expr1 == null || expr2 == null)
            throw new IllegalArgumentException ("null Expression");
        this.relationalOperator=relationOperator;
        this.expr1=expr1;
        this.expr2=expr2;
    }
    /**
     * @return value of the BooleanExpression
     * @throws exceptions.UndefinedVariable if an undefined variable is in BooleanExpression at evaluate time
     */
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
