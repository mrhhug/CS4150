/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */
package parser;

import globals.ArithmeticOperatorLexeme;

public class BinaryExpression implements Expression
{

    private ArithmeticOperatorLexeme arithmeticOperator;
    private Expression expr1;
    private Expression expr2;

    /**
     * precondition: e0 & e1 are not null
     * @param arithmeticOperator
     * @param expr1
     * @param expr2
     */
    public BinaryExpression(ArithmeticOperatorLexeme arithmeticOperator, Expression expr1, Expression expr2)
    {
        if (expr1 == null || expr2 == null)
            throw new IllegalArgumentException ("null expression argument");
        this.arithmeticOperator = arithmeticOperator;
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    /**
     * @return value of the expression
     */
    public int evaluate() throws exceptions.UndefinedVariable
    {
        int value = 0;
        switch (arithmeticOperator)
        {
            case ADD:
                value = expr1.evaluate() + expr2.evaluate();
                break;
            case SUB:
                value = expr1.evaluate() - expr2.evaluate();
                break;
            case MUL:
                value = expr1.evaluate() * expr2.evaluate();
                break;
            case DIV:
                value = expr1.evaluate() / expr2.evaluate();
                break;
        }
        return value;
    }	
}