/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */
package parser;

import exceptions.LexException;
import exceptions.UndefinedVariable;
import lexicalanalyzer.Token;

class BooleanExpression
{
    Expression expression1;
    Expression expression2;
    Token token;
    /**
     * preconditions: token is relationalOperator, expression1 is not null, expression2 is not null
     * postcondition: BooleanExpression is created
     * @param token
     * @param expression1
     * @param expression2
     */
    BooleanExpression(Token token, Expression expression1, Expression expression2)
    {
        if (!token.isRelationalOperator())
            throw new IllegalArgumentException ("RelationalOperator expected");
        if (expression1 == null || expression2 == null)
            throw new IllegalArgumentException ("null Expression");
        this.token=token;
        this.expression1=expression1;
        this.expression2=expression2;
    }
    /**
     * @return value of the BooleanExpression
     * @throws UndefinedVariable if an undefined variable is in BooleanExpression at evaluate time
     * @throws LexException token is not a relationalOperator
     */
    boolean evaluate() throws UndefinedVariable, LexException
    {
        switch (token.getRelationalOperator())
        {
            case LE:  
                return expression1.evaluate() <= expression2.evaluate();
            case LT:  
                return expression1.evaluate() < expression2.evaluate();
            case GE:  
                return expression1.evaluate() >= expression2.evaluate();
            case GT:  
                return expression1.evaluate() > expression2.evaluate();
            case EQ:  
                return expression1.evaluate() == expression2.evaluate();
            case NE:  
                return expression1.evaluate() != expression2.evaluate();
        }
        throw new LexException("RelationalOperator expected",token);
    }
}
