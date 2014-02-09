package parser;

import enumerated_lists.Keyword;
import lexicalanalyzer.Token;
import static_classes.tl;
import static enumerated_lists.Keyword.DO;
import static enumerated_lists.Keyword.END;
import static enumerated_lists.Keyword.UNTIL;
import static enumerated_lists.Keyword.WHILE;
import exceptions.RuntimeError;

public abstract class loop implements statement
{
    boolean_expression be;
    code_block cb;
    
    loop() throws RuntimeError
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
class until_statement extends loop
{
    until_statement() throws RuntimeError 
    {   }
    
    @Override
    public void evaluate() throws RuntimeError
    {
        while(!be.evaluate())
            cb.evaluate();
    }
}
class while_statement extends loop
{
    while_statement() throws RuntimeError
    {    }
    
    @Override
    public void evaluate() throws RuntimeError
    {
        while(be.evaluate())
            cb.evaluate();
    } 
}
