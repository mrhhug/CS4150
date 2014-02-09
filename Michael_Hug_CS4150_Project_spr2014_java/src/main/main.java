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
        String fileName = "ruby.rb";
        new Tokenizer(fileName);
        new Parser();
    }
}