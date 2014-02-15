/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package Interpreter;

public class main 
{
    public static void main(String[] args)
    {
        String fileName;
        if (args.length == 0)
			fileName = "./../ruby.rb";
        else
            fileName = args[0];
        try
        {
            new parser.Parser(new lexicalanalyzer.Tokenizer(fileName));
        }
        catch (exceptions.LexException e)
        {
            System.out.println(e.getMessage() + " row: " + e.getRowNumber() + " column: " + e.getColumnNumber());
            e.printStackTrace();
        }
        catch (java.io.FileNotFoundException e)
        {
            System.out.println("source file not found");
            e.printStackTrace();
        }
        catch (java.io.IOException e)
        {
            System.out.println("source file error while reading");
            e.printStackTrace();
        }
        catch (IllegalArgumentException e)
        {
            System.out.println (e.getMessage());
            e.printStackTrace();
        }
        catch (exceptions.UndefinedVariable e)
        {
            System.out.println("Undefined variable '" + e.getID() + "' row: " + e.getRowNumber() + " column " + e.getColumnNumber());
            e.printStackTrace();
        }
        catch (exceptions.aWildKeystrokeAppeared e)
        {
            System.out.println("Gibberish found '" + e.getgibberish() + "' row: " + e.getRowNumber() + " column " + e.getColumnNumber());
            e.printStackTrace();
        }
    }
}