package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


/**
 *
 * @author michael
 */
public class Project 
{
    public static void main(String[] args) throws FileNotFoundException, IOException, aWildKeystrokeAppeared, arithmetic_operator_expected_exception, Nodefkeywordexception, Noendkeywordexception, StatementExpectedException, UndefinedVariableException, AssignemntOperatorExpectedException
    {     
        String path = "/home/michael/School/CSCI/CS4150/project/src/project/ruby.rb";
        File file = new File(path);
        Scanner scn = new Scanner(file);
        program prg = new program();
        int tokenNum =1;
        int ExitCode = 1;
        System.out.println("make tokens a class and insert linenumber\n\n");
        
        while (scn.hasNext()) 
        {
            ExitCode= prg.recepticle(scn.next(),tokenNum);
            tokenNum++;
        }
        prg.recepticle("poison",-1);
        
        /*
                s = new Scanner(new BufferedReader(new FileReader("input.txt")));

                for (int lineNum=1; s.hasNext(); lineNum++) {
                   System.out.print("Line number " + lineNum + ": " + s.next());
                }
        */
        
        
        
        
        
        /*
        String token = "op";
        boolean flag =false;
        if(token.matches("[a-zA-Z]"))
            flag = true;
        System.out.println(flag);
                */
        if (ExitCode==0)
        {
            System.out.println("dude where is my end statement?");
        }
    }
}
