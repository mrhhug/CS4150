/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */
package lexicalanalyzer;

import exceptions.aWildKeystrokeAppeared;
import static globals.ArithmeticOperatorLexeme.*;
import globals.KeywordLexeme;
import static globals.RelationalOperatorLexeme.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Tokenizer
{
   private final java.util.List<Token> TokenList;
    /**
     * precondition: fileName is not null
     * postcondition: file is translated to TokenList
     * @param fileName
     * @throws aWildKeystrokeAppeared if characters surrounded by whitespace can not be parsed as lexeme
     * @throws FileNotFoundException if file can not be found
     * @throws IOException  if an error occurs while reading file
     */       
    public Tokenizer(String fileName) throws aWildKeystrokeAppeared, FileNotFoundException, IOException
    {
        TokenList = new java.util.LinkedList<>();
        if (fileName == null)
            throw new IllegalArgumentException ("null string argument");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),Charset.forName("UTF-8")));
        String buffer = "";
        int c;
        int rowNumber = 1;
        int columnNumber = 1;
        while((c = reader.read()) != -1)
        {
            //System.out.println(c);
            if(Character.isWhitespace(c))
            {
                if(!buffer.isEmpty())
                    add(newToken(buffer,rowNumber,columnNumber));
                buffer = "";
            }
            else
            {
                buffer+=(char)c;
            }
            if(c == '\n' || c == '\r')
            {
                rowNumber++;
                columnNumber=0;
            }
            columnNumber++;
        }
        add(new Token(globals.KeywordLexeme.EOF,rowNumber,columnNumber));
    }
    /**
     * @param s
     * @param rowNumber
     * @param columnNumber
     * @returns Token
     * @throws aWildKeystrokeAppeared if string cannot be parsed as lexeme
     */
    private Token newToken(String s, int rowNumber, int columnNumber) throws aWildKeystrokeAppeared
    {
        Token t;
        if(s.matches("[a-zA-Z]"))
            t = new Token(s.charAt(0), rowNumber, columnNumber);
        else if(isInteger(s))
            t = new Token(Integer.parseInt(s), rowNumber, columnNumber);
        else if(isKeyword(s))
            t = new Token(KeywordLexeme.valueOf(s.toUpperCase()), rowNumber, columnNumber);
        else if(otherLexeme(s))
        {
            switch (s)
            {
                case "=":
                    t = new Token(globals.KeywordLexeme.ASSIGN, rowNumber, columnNumber);
                    break;
                case "<=":
                    t = new Token(LE, rowNumber, columnNumber);
                    break;
                case "<":
                    t = new Token(LT, rowNumber, columnNumber);
                    break;
                case ">=":
                    t = new Token(GE, rowNumber, columnNumber);
                    break;
                case ">":
                    t = new Token(GT, rowNumber, columnNumber);
                    break;
                case "==":
                    t = new Token(EQ, rowNumber, columnNumber);
                    break;
                case "/=":
                    t = new Token(NE, rowNumber, columnNumber);
                    break;
                case "+":
                    t = new Token(ADD, rowNumber, columnNumber);
                    break;
                case "-":
                    t = new Token(SUB, rowNumber, columnNumber);
                    break;
                case "*":
                    t = new Token(MUL, rowNumber, columnNumber);
                    break;
                //case "/":
                default:
                    t = new Token(DIV, rowNumber, columnNumber);
                    break;
            }
        }
        else
            throw new aWildKeystrokeAppeared(s, rowNumber, columnNumber);
        return t;
    }
    /**
     * @param s
     * @returns true if s is one of my other lexemes
     */
    private boolean otherLexeme(String s)
    {
        return s.equals("=")||s.equals("<=")||s.equals("<")||s.equals(">=")||s.equals(">")||
                s.equals("==")||s.equals("/=")||s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/");
    }
    /**
     * @param s
     * @returns true if java can parse string as KeywordLexeme
     */
    private boolean isKeyword(String s)
    {
        boolean returnme = false;
        try
        {
            KeywordLexeme.valueOf(s.toUpperCase());
            returnme = true;
        }
        catch( IllegalArgumentException e )
        { }
        return returnme;
    }
    /**
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
     * precondition: TokenList is not null
     * postcondition: Token is added to TokenList
     * @throws IllegalArgumentException if tokens is null
     * @param token
     */
    private void add(Token token)
    {
        if(TokenList==null)
            throw new IllegalArgumentException ("null TokenList");
        TokenList.add(token);
    }
    /**
     * precondition: TokenList is not empty
     * @return token at front of list removing the token from the list
     * @throws IllegalArgumentException if tokens is empty
     */
    public Token pop()
    {
        if (!moreTokens())
                throw new IllegalArgumentException ("no more tokens");
        return TokenList.remove(0);
    }
    /**
     * precondition: TokenList is not empty
     * @return token at front of list leaving token on list
     * @throws IllegalArgumentException if tokens is empty
     */
    public Token peek()
    {
        if (!moreTokens())
                throw new IllegalArgumentException ("no more tokens");
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