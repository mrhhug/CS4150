package parser;

import lexicalanalyzer.Token;
import exceptions.RuntimeError;
import static_classes.memory;
import static_classes.tl;

interface statement
{
    void evaluate() throws RuntimeError;
}

class if_statement implements statement
{
    boolean_expression be;
    code_block cb0;
    code_block cb1;
    
    if_statement() throws RuntimeError
    {
        Token t = tl.pop();
        if(t.getKeyword()!=enumerated_lists.Keyword.IF)
            throw new RuntimeError("if statment expected",t);
        be = new boolean_expression();
        
        t = tl.pop();
        if(t.getKeyword()!=enumerated_lists.Keyword.THEN)
            throw new RuntimeError("then keyword expected",t);
        cb0 = new code_block();
        
        t = tl.pop();
        if(t.getKeyword()!=enumerated_lists.Keyword.ELSE)
            throw new RuntimeError("else keyword expected",t);
        cb1 = new code_block();
        
        t = tl.pop();
        if(t.getKeyword()!=enumerated_lists.Keyword.END)
            new RuntimeError("end keyword expected",t);
    }
    public void evaluate() throws RuntimeError
    {
        if(be.evaluate())
            cb0.evaluate();
        else
            cb1.evaluate();
    }
}

class print_statement implements statement
{
    expresion e;
    
    public print_statement() throws RuntimeError
    {
        Token t = tl.pop();
        if(t.getKeyword()!=enumerated_lists.Keyword.PUTS)
            throw new RuntimeError("puts statement expected",t);
        e = new expresion();
    }

    @Override
    public void evaluate() throws RuntimeError
    {
        //ruby appends newline to puts
        System.out.println(e.evaluate());
    }  
}

class assignment_statement implements statement
{
    Token t;
    expresion e;
    
    public assignment_statement() throws RuntimeError
    {
        t=tl.pop();
        if(t.getCharacter()==null)
            throw new RuntimeError("id expected",t);
        
        if(tl.pop().getKeyword()!=enumerated_lists.Keyword.ASSIGN)
            throw new RuntimeError("assignement lexime expected",t);
        
        e = new expresion();
    }

    @Override
    public void evaluate() throws RuntimeError
    {
        memory.set(t,e.evaluate());
    }   
}