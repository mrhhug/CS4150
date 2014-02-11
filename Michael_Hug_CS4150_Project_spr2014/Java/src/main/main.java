/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package main;

import lexicalanalyzer.Tokenizer;
import java.io.IOException;
import parser.Parser;
import exceptions.RuntimeError;
import exceptions.aWildKeystrokeAppeared;

public class main 
{
    public static void main(String[] args) throws aWildKeystrokeAppeared, IOException, RuntimeError
    {
        String fileName;
        if (args.length == 0)
			fileName = "./../ruby.rb";
        else
            fileName = args[0];
        new Tokenizer(fileName);
        new Parser();
    }
}