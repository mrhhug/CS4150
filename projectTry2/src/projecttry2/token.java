package projecttry2;

class token 
{
    private final int lineNumber,colNumber;
    private final String str;
    
    token(String str, int lineNumber, int colNumber)
    {
        this.lineNumber = lineNumber;
        this.colNumber = colNumber;
        this.str=str;
    }
    public String tokentype()
    {
        return str;
    }
    public int getlineNumber()
    {
        return lineNumber;
    }
    public int getcolNumber()
    {
        return colNumber;
    }
}


















/*
class program extends token
{
    program()
    {
        new code_block();
    }
}
class code_block extends program {}
class statement extends code_block {}

class assignment_statement extends statement {}
class print_statement extends statement {}
class while_statement extends statement {}
class if_statement extends statement {}

class until_statement extends statement {}





class expression extends code_block {} 
class arithmetic_operator extends expression {}
class add_operator extends arithmetic_operator {}
class sub_operator extends arithmetic_operator {}
class mult_operator extends arithmetic_operator {}
class div_operator extends arithmetic_operator {}

add_operator

token(int lineNumber,int colNumber)
    {
        this.lineNumber=lineNumber;
        this.colNumber=colNumber;       
    }

        
        

        
code_block()
{

}
        statement()
{

}
      expression()
{

}
        
      arithmetic_operator()
{

}
        
        add_operator() extends token
        {
        }











class Def extends token
{
    public Def (int lineNumber, int colNumber)
    {
        super(lineNumber, colNumber);
    }
}
class End extends token
{
    public End (int lineNumber, int colNumber)
    {
        super(lineNumber, colNumber);
    }
}
class If extends token
{
    public If (int lineNumber, int colNumber)
    {
        super(lineNumber, colNumber);
    }
}
class Else extends token
{
    public Else (int lineNumber, int colNumber)
    {
        super(lineNumber, colNumber);
    }
}
class While extends token
{
    public While (int lineNumber, int colNumber)
    {
        super(lineNumber, colNumber);
    }
}
class Do extends token
{
    public Do (int lineNumber, int colNumber)
    {
        super(lineNumber, colNumber);
    }
}
class Puts extends token
{
    public Puts (int lineNumber, int colNumber)
    {
        super(lineNumber, colNumber);
    }
}
class Until extends token
{
    public Until (int lineNumber, int colNumber)
    {
        super(lineNumber, colNumber);
    }
}
*/