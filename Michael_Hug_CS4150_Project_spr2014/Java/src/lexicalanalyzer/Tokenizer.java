/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package lexicalanalyzer;

import static globals.ArithmeticOperatorLexeme.*;
import static globals.KeywordLexeme.*;
import static globals.RelationalOperatorLexeme.*;
import exceptions.aWildKeystrokeAppeared;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Tokenizer
{
   private final java.util.List<Token> TokenList;
           
    public Tokenizer(String fileName) throws aWildKeystrokeAppeared, FileNotFoundException, IOException
    {
        TokenList = new java.util.LinkedList<>();
        if (fileName == null)
            throw new IllegalArgumentException ("null string argument");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),Charset.forName("UTF-8")));
        String buffer = "";
        int c;
        int lineNumber = 1;
        int colNumber = 1;
        while((c = reader.read()) != -1)
        {
            //System.out.println(c);
            if(Character.isWhitespace(c))
            {
                if(!buffer.isEmpty())
                    add(newToken(buffer,lineNumber,colNumber));
                buffer = "";
            }
            else
            {
                buffer+=(char)c;
            }
            if(c == '\n' || c == '\r')
            {
                lineNumber++;
                colNumber=0;
            }
            colNumber++;
        }
        add(new Token(EOF,lineNumber,colNumber));
    }
    
    /**
     * creates a new token from string, line number, and column number
     * @param s
     * @param lineNumber
     * @param colNumber
     * @returns Token
     * @throws aWildKeystrokeAppeared 
     */
    private Token newToken(String s, int lineNumber, int colNumber) throws aWildKeystrokeAppeared
    {
        Token t;
        if(s.matches("[a-zA-Z]"))
            t = new Token(s.charAt(0), lineNumber, colNumber);
        else if(isInteger(s))
            t = new Token(Integer.parseInt(s), lineNumber, colNumber);
        else
        {
            switch (s)
            {
                case "def":
                    t = new Token(DEF, lineNumber, colNumber);
                    break;
                case "end":
                    t = new Token(END, lineNumber, colNumber);
                    break;
                case "if":
                    t = new Token(IF, lineNumber, colNumber);
                    break;
                case "then":
                    t = new Token(THEN, lineNumber, colNumber);
                    break;
                case "else":
                    t = new Token(ELSE, lineNumber, colNumber);
                    break;
                case "while":
                    t = new Token(WHILE, lineNumber, colNumber);
                    break;
                case "do":
                    t = new Token(DO, lineNumber, colNumber);
                    break;
                case "puts":
                    t = new Token(PUTS, lineNumber, colNumber);
                    break;
                case "until":
                    t = new Token(UNTIL, lineNumber, colNumber);
                    break;
                case "=":
                    t = new Token(ASSIGN, lineNumber, colNumber);
                    break;
                case "<=":
                    t = new Token(LE, lineNumber, colNumber);
                    break;
                case "<":
                    t = new Token(LT, lineNumber, colNumber);
                    break;
                case ">=":
                    t = new Token(GE, lineNumber, colNumber);
                    break;
                case ">":
                    t = new Token(GT, lineNumber, colNumber);
                    break;
                case "==":
                    t = new Token(EQ, lineNumber, colNumber);
                    break;
                case "/=":
                    t = new Token(NE, lineNumber, colNumber);
                    break;
                case "+":
                    t = new Token(ADD, lineNumber, colNumber);
                    break;
                case "-":
                    t = new Token(SUB, lineNumber, colNumber);
                    break;
                case "*":
                    t = new Token(MUL, lineNumber, colNumber);
                    break;
                case "/":
                    t = new Token(DIV, lineNumber, colNumber);
                    break;
                default: 
                    throw new aWildKeystrokeAppeared(s,lineNumber, colNumber);
            }
        }
        return t;
    }
    /**
     * trys to get java to parse string as integer
     * @param s
     * @returns true if java can parse string as integer
     */
    private boolean isInteger(String s)
    {
        boolean returnme = false;
        try
        {
            Integer.parseInt(s);
            returnme = true;
        }
        catch( NumberFormatException e )
        { }
        return returnme;
    }
    /**
     * adds token to tokenlist
     * @param t 
     */
    private void add(Token t)
    {
        TokenList.add(t);
    }
    /**
     * precondition: tokenlist is not empty
     * @return token at front of list removing the token from the list
     * @throws RuntimeException if tokens is empty
     */
    public Token pop()
    {
        if (!moreTokens())
                throw new RuntimeException ("no more tokens");
        return TokenList.remove(0);
    }
    /**
     * precondition: tokenlist is not empty
     * @return token at front of list leaving token on list
     * @throws RuntimeException if tokens is empty
     */
    public Token peek()
    {
        if (!moreTokens())
                throw new RuntimeException ("no more tokens");
        return TokenList.get(0);
    }
    /**
     * @return true if there are more tokens - false otherwise
     */
    public boolean moreTokens ()
    {
        return !TokenList.isEmpty();
    }
}