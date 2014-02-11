/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package exceptions;

public class aWildKeystrokeAppeared extends Exception
{
    public aWildKeystrokeAppeared(int lineNumber, int colNumber) 
    {
        System.out.println("A wild keystroke appeared at line number, column number "+lineNumber+","+colNumber);
        System.exit(1);
    }  
}
