package other;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.Queue;



import static tokenz.Keyword.*;
import static tokenz.Relational_Operator.*;
import static tokenz.Arithmetic_Operator.*;

import tokenz.Token;


public class tokenizer 
{
    Queue<Token> tokenList;
    
    tokenizer(String fileName) throws FileNotFoundException, IOException, aWildKeystrokeAppeared
    {
        tokenList = new LinkedList<>();
        
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
                    tokenList.add(newToken(buffer,lineNumber,colNumber));
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
        tokenList.add(new Token(EOF,-1,-1));
        //return tokenList;
    }
    private Token newToken(String s, int lineNumber, int colNumber) throws aWildKeystrokeAppeared
    {
        Token t;
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
                throw new aWildKeystrokeAppeared(lineNumber, colNumber);
        }
        return t;
    }
    public Queue<Token> getQueue()
    {
        return tokenList;
    }
}
