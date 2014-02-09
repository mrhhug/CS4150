package other;

class code_blockOLD
{
    //final TokenList tl;
    //final private memory mem;
    class code_blockOLD() 
    {
        mem = new memory();
        tl = new TokenList();
    }
    void trigger() throws AssignemntOperatorExpectedException, LiteralIntegerExpectedException, idExpectedException, StatementExpectedException, DivideByZeroException, RedRover, UndefinedVariableException, ExpressionExpectedException, RelationalOperatorExpectedException, Nothenkeywordexception, Noelsekeywordexception, Noendkeywordexception
    {
       Token t;
       t = tl.getNextToken();
       while(t.id!=null || t.k==IF || t.k==WHILE || t.k==PUTS || t.k==UNTIL)
            statement(t);
       //thjis needs to pass the keyword and then do more stuff.
    }
}
