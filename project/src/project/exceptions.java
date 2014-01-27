package project;

class Nodefkeywordexception extends Exception 
{
    public Nodefkeywordexception(int tokenNum)
    {
        System.out.print("Expecting 'def' keyword at token "+tokenNum);
        System.exit(1);
    }   
}
class Noendkeywordexception extends Exception 
{
    public Noendkeywordexception(int tokenNum)
    {
        System.out.print("Expecting 'end' keyword at token "+tokenNum);
        System.exit(2);
    } 
}
class StatementExpectedException extends Exception
{
    public StatementExpectedException(int tokenNum) 
    {
        System.out.println("Statement expected but not found near token number "+tokenNum);
        System.exit(3);
    }
}
class arithmetic_operator_expected_exception extends Exception 
{
    public arithmetic_operator_expected_exception(int tokenNum) 
    {
        System.out.println("arithmetic_operator expected but not found near token number "+tokenNum);
        System.exit(4);
    }
}
class UndefinedVariableException extends Exception
{
    public UndefinedVariableException(int tokenNum)
    {
        System.out.println("undefined variable attempted to be accesed near token number "+tokenNum);
        System.exit(5);
    }
}
class aWildKeystrokeAppeared extends Exception
{
    public aWildKeystrokeAppeared(int tokenNum) 
    {
        System.out.println("aWildKeystrokeAppeared near token "+ tokenNum);
        System.exit(6);
    }
    
}
class AssignemntOperatorExpectedException extends Exception 
{
    public AssignemntOperatorExpectedException(int tokenNum)
    {
        System.out.print("Expecting '='  at token "+tokenNum);
        System.exit(2);
    } 
}