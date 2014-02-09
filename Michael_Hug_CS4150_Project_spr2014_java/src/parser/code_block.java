/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package parser;

import lexicalanalyzer.Token;
import static_classes.tl;
import exceptions.RuntimeError;

public class code_block
{
    java.util.List<statemeniInterface> statementList;
    
    code_block() throws RuntimeError
    {
        statementList = new java.util.LinkedList();
        while(nexttokenBeginsStatement(tl.peek()));
    }
    private boolean nexttokenBeginsStatement(Token t) throws RuntimeError
    {
        boolean returnme = false;
        switch (t.getKeyword())
        {
            case IF:  
                statementList.add(new if_statement());
                returnme = true;
                break;
            case WHILE:
                statementList.add(new while_statement());
                returnme = true;
                break;
            case ID:
                statementList.add(new assignment_statement());
                returnme = true;
                break;
            case PUTS:
                statementList.add(new print_statement());
                returnme = true;
                break;
            case UNTIL:
                statementList.add(new until_statement());
                returnme = true;
        }
        return returnme;
    }
    void evaluate() throws RuntimeError
    {
        for(int i =0;i<statementList.size();i++)
            statementList.get(i).evaluate();
    }
}
