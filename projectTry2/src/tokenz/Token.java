package tokenz;

public class Token
{
    public Arithmetic_Operator a;
    public Character id;
    public Keyword k;
    public Integer li;
    public Relational_Operator r;
    public int lineNumber;
    public int colNumber;
    
    public Token(Arithmetic_Operator a, int lineNumber, int colNumber)
    {
        this.a = a;    
        this.lineNumber = lineNumber;
        this.colNumber = colNumber;
    }
    public Token(Character id, int lineNumber, int colNumber)
    {
        this.id = id;
        this.lineNumber = lineNumber;
        this.colNumber = colNumber;
    }
    public Token(Keyword k, int lineNumber, int colNumber)
    {
        this.k = k;
        this.lineNumber = lineNumber;
        this.colNumber = colNumber;
    }
    public Token(Integer li, int lineNumber, int colNumber)
    {
        this.li = li;
        this.lineNumber = lineNumber;
        this.colNumber = colNumber;
    }
    public Token(Relational_Operator r, int lineNumber, int colNumber)
    {
        this.r = r;
        this.lineNumber = lineNumber;
        this.colNumber = colNumber;
    }
}