/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package parser;

import enumerated_lists.Keyword;
import lexicalanalyzer.Token;
import static_classes.tl;
import static enumerated_lists.Keyword.DO;
import static enumerated_lists.Keyword.END;
import static enumerated_lists.Keyword.UNTIL;
import static enumerated_lists.Keyword.WHILE;
import exceptions.RuntimeError;

public abstract class abstractloop implements statemeniInterface
{
    boolean_expression be;
    code_block cb;
    
    abstractloop() throws RuntimeError
    {
        Token t = tl.pop();
        Keyword k = t.getKeyword();
        if(k!=WHILE && k!=UNTIL)
            throw new RuntimeError("while or untill statment expected",t);
        be = new boolean_expression();
        
        t = tl.pop();
        if(t.getKeyword()!=DO)
            throw new RuntimeError("do keyword expected",t);
        cb = new code_block();
              
        t = tl.pop();
        if(t.getKeyword()!=END)
            new RuntimeError("end keyword expected",t);
    }
}
