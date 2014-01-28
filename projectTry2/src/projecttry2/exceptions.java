package projecttry2;

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
    public Nodefkeywordexception(token t)
    {
        System.out.print("Expecting 'def' keyword at line number, column number "+t.getlineNumber()+","+t.getcolNumber());
        System.exit(2);
    }   
}
class Noendkeywordexception extends Exception 
{
    public Noendkeywordexception(token t)
    {
        System.out.print("Expecting 'end' keyword at line number, column number "+t.getlineNumber()+","+t.getcolNumber());
        System.exit(3);
    } 
}
class AssignemntOperatorExpectedException extends Exception 
{
    public AssignemntOperatorExpectedException(token t)
    {
        System.out.print("Expecting '='  at line number, column number "+t.getlineNumber()+","+t.getcolNumber());
        System.exit(2);
    } 
}
class LiteralIntegerExpectedException extends Exception
{
    public LiteralIntegerExpectedException(token t)
    {
        System.out.print("Expecting literal_integer at line number, column number "+t.getlineNumber()+","+t.getcolNumber());
        System.exit(5);
    }
}
class idExpectedException extends Exception
{
    public idExpectedException(token t)
    {
        System.out.print("Expecting id at line number, column number "+t.getlineNumber()+","+t.getcolNumber());
        System.exit(5);
    }
}
class StatementExpectedException extends Exception
{
    public StatementExpectedException(int tokenNum) 
    {
        System.out.println("Statement expected but not found near token number "+tokenNum);
        System.exit(4);
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

