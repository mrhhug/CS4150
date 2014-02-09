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