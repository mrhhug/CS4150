package lexicalanalyzer;

import enumerated_lists.Arithmetic_Operator;
import enumerated_lists.Keyword;
import enumerated_lists.Relation_Operator;

public class Token
{
    private Arithmetic_Operator a;
    private Character c;
    private Integer i;
    private Keyword k;
    private Relation_Operator r;
    private final int lineNumber;
    private final int colNumber;
    
    Token(Arithmetic_Operator a, int lineNumber, int colNumber)
    {
        this.a = a;
        this.lineNumber = lineNumber;
        this.colNumber = colNumber;
    }
    Token(Character c, int lineNumber, int colNumber)
    {
        this.c = c;
        this.k = enumerated_lists.Keyword.ID;
        this.lineNumber = lineNumber;
        this.colNumber = colNumber;
    }
    Token(Integer i, int lineNumber, int colNumber)
    {
        this.i = i;
        this.lineNumber = lineNumber;
        this.colNumber = colNumber;
    }
    Token(Keyword k, int lineNumber, int colNumber)
    {
        this.k = k;
        this.lineNumber = lineNumber;
        this.colNumber = colNumber;
    }
    Token(Relation_Operator r, int lineNumber, int colNumber)
    {
        this.r = r;
        this.lineNumber = lineNumber;
        this.colNumber = colNumber;
    }
    public int getlineNumber()
    {
        return lineNumber;
    }
    public int getcolNumber()
    {
        return colNumber;
    }
    public Arithmetic_Operator getArithmetic_Operator()
    {
        return a;
    }
    public Character getCharacter()
    {
        return c;
    }
    public Integer getInteger()
    {
        return i;
    }
    public Keyword getKeyword()
    {
        return k;
    }
    public Relation_Operator getRelation_Operator()
    {
        return r;
    }
}
