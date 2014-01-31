package other;

import tokenz.Token;

class aWildKeystrokeAppeared extends Exception
{
    public aWildKeystrokeAppeared(int lineNumber, int colNumber) 
    {
        System.out.println("aWildKeystrokeAppeared at line number, column number "+lineNumber+","+colNumber);
        System.exit(1);
    }  
}
class Nodefkeywordexception extends Exception 
{
    public Nodefkeywordexception(Token t)
    {
        System.out.print("Expecting 'def' keyword at line number, column number "+t.lineNumber+","+t.colNumber);
        System.exit(2);
    }   
}
class Nothenkeywordexception extends Exception 
{
    public Nothenkeywordexception(Token t)
    {
        System.out.print("Expecting 'then' keyword at line number, column number "+t.lineNumber+","+t.colNumber);
        System.exit(2);
    }   
}
class Noelsekeywordexception extends Exception 
{
    public Noelsekeywordexception(Token t)
    {
        System.out.print("Expecting 'else' keyword at line number, column number "+t.lineNumber+","+t.colNumber);
        System.exit(2);
    }   
}
class Noendkeywordexception extends Exception 
{
    public Noendkeywordexception(Token t)
    {
        System.out.print("Expecting 'end' keyword at line number, column number "+t.lineNumber+","+t.colNumber);
        System.exit(3);
    } 
}
class AssignemntOperatorExpectedException extends Exception 
{
    public AssignemntOperatorExpectedException(Token t)
    {
        System.out.print("Expecting '='  at line number, column number "+t.lineNumber+","+t.colNumber);
        System.exit(2);
    } 
}
class LiteralIntegerExpectedException extends Exception
{
    public LiteralIntegerExpectedException(Token t)
    {
        System.out.print("Expecting literal_integer at line number, column number "+t.lineNumber+","+t.colNumber);
        System.exit(5);
    }
}
class idExpectedException extends Exception
{
    public idExpectedException(Token t)
    {
        System.out.print("Expecting id at line number, column number "+t.lineNumber+","+t.colNumber);
        System.exit(5);
    }
}
class StatementExpectedException extends Exception
{
    public StatementExpectedException(Token t) 
    {
        System.out.println("Expecting Statement but not found near Token number "+t.lineNumber+","+t.colNumber);
        System.exit(4);
    }
}
class ExpressionExpectedException extends Exception
{
    public ExpressionExpectedException(Token t) 
    {
        System.out.println("Expecting Expression but not found near Token number "+t.lineNumber+","+t.colNumber);
        System.exit(4);
    }
}
class ArithmeticOperatorExpectedException extends Exception 
{
    public ArithmeticOperatorExpectedException(Token t) 
    {
        System.out.println("Expecting arithmetic_operator but not found near Token number "+t.lineNumber+","+t.colNumber);
        System.exit(4);
    }
}
class RelationalOperatorExpectedException extends Exception 
{
    public RelationalOperatorExpectedException(Token t) 
    {
        System.out.println("Expecting Relational_Operator but not found near Token number "+t.lineNumber+","+t.colNumber);
        System.exit(4);
    }
}
class UndefinedVariableException extends Exception
{
    public UndefinedVariableException(Token t)
    {
        System.out.println("undefined variable attempted to be accesed near Token number "+t.lineNumber+","+t.colNumber);
        System.exit(5);
    }
}
class DivideByZeroException extends Exception
{
    DivideByZeroException(Token t)
    {
        System.out.println("an attempt was made to divide by zero at "+t.lineNumber+","+t.colNumber);
        System.exit(5);
    }
}
class RedRover extends Exception
{
    public RedRover(int lineNumber, int colNumber) 
    {
        ///how did oyu get here? 
        System.out.println("Whoops.... Looks like all the programmers are busy playing red rover. We'll send someone right over. "+lineNumber+","+colNumber);
        System.exit(1);
    }  
}
