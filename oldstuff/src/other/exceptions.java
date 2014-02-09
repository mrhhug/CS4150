package other;

class ParserException extends Exception
{
    public ParserException(String s, Token t) 
    {
        System.out.println(s+" at line number, column number "+t.lineNumber+","+t.colNumber);
        System.exit(1);
    }  
}
class UndefinedVariableException extends Exception
{
    public UndefinedVariableException(Token t) 
    {
        System.out.println("Undefined variable at line number, column number "+t.lineNumber+","+t.colNumber);
        System.exit(2);
    }  
}
