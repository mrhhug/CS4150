package other;

import goodtry.Relational_Operator;
import goodtry.Keyword;
import goodtry.ArithmeticOperatorEnum;

public class Token
{
    final public ArithmeticOperatorEnum a;
    final public Character id;
    final public Keyword k;
    final public Integer li;
    final public Relational_Operator r;
    final public int lineNumber;
    final public int colNumber;
    
    public Token(ArithmeticOperatorEnum a, int lineNumber, int colNumber)
    {
        this.a = a;
        this.id = null;
        this.k = null;
        this.li = null;
        this.r = null;
        this.lineNumber = lineNumber;
        this.colNumber = colNumber;
    }
    public Token(Character id, int lineNumber, int colNumber)
    {
        this.a = null;
        this.id = id;
        this.k = null;
        this.li = null;
        this.r = null;
        this.lineNumber = lineNumber;
        this.colNumber = colNumber;
    }
    public Token(Keyword k, int lineNumber, int colNumber)
    {
        this.a = null;
        this.id = null;
        this.k = k;
        this.li = null;
        this.r = null;
        this.lineNumber = lineNumber;
        this.colNumber = colNumber;
    }
    public Token(Integer li, int lineNumber, int colNumber)
    {
        this.a = null;
        this.id = null;
        this.k = null;
        this.li = li;
        this.r = null;
        this.lineNumber = lineNumber;
        this.colNumber = colNumber;
    }
    public Token(Relational_Operator r, int lineNumber, int colNumber)
    {
        this.a = null;
        this.id = null;
        this.k = null;
        this.li = null;
        this.r = r;
        this.lineNumber = lineNumber;
        this.colNumber = colNumber;
    }
}