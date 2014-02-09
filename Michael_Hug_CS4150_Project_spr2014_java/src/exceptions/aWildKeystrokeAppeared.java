package exceptions;

public class aWildKeystrokeAppeared extends Exception
{
    public aWildKeystrokeAppeared(int lineNumber, int colNumber) 
    {
        System.out.println("A wild keystroke appeared at line number, column number "+lineNumber+","+colNumber);
        System.exit(1);
    }  
}
