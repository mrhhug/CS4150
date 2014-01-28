package projecttry2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.Queue;

public class tokenizer 
{
    Queue<token> tokenList;
    
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
                    tokenList.add(new token(buffer,lineNumber,colNumber));
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
        tokenList.add(new token("",-1,-1));
        //return tokenList;
    }
    private token newToken(String buffer, int lineNumber, int colNumber) throws aWildKeystrokeAppeared
    {
        if(!keyword.isKeyword(buffer) && !keyword.isLexeme(buffer))
        {
            throw new aWildKeystrokeAppeared(lineNumber,colNumber);
        }
        return new token(buffer,lineNumber,colNumber);
    }
    public Queue<token> getQueue()
    {
        return tokenList;
    }
}
