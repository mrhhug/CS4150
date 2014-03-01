/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */
package Interpreter;

import exceptions.LexException;
import exceptions.UndefinedVariable;
import exceptions.aWildKeystrokeAppeared;
import java.io.FileNotFoundException;
import java.io.IOException;
import lexicalanalyzer.Tokenizer;
import parser.Parser;

public class Interpreter 
{
    public static void main(String[] args)
    {
        args = new String [] {"./ruby.rb"};
        if (args.length == 0)
			System.out.println("java Interpreter file_name expected");
        else
        {
            try
            {
                new Parser(new Tokenizer(args[0]));
            }
            catch (LexException e)
            {
                System.out.println(e.getMessage() + " row: " + e.getRowNumber() + " column: " + e.getColumnNumber());
                e.printStackTrace();
            }
            catch (FileNotFoundException e)
            {
                System.out.println("source file not found");
                e.printStackTrace();
            }
            catch (IOException e)
            {
                System.out.println("error while reading file");
                e.printStackTrace();
            }
            catch (IllegalArgumentException e)
            {
                System.out.println (e.getMessage());
                e.printStackTrace();
            }
            catch (UndefinedVariable e)
            {
                System.out.println("Undefined variable '" + e.getID() + "' row: " + e.getRowNumber() + " column " + e.getColumnNumber());
                e.printStackTrace();
            }
            catch (aWildKeystrokeAppeared e)
            {
                System.out.println("Gibberish found '" + e.getGibberish() + "' row: " + e.getRowNumber() + " column " + e.getColumnNumber());
                e.printStackTrace();
            }
        }
    }
}
