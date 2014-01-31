package other;

import tokenz.Token;

public class memory 
{
    final Integer mem[] = new Integer[52];
    
    public void set(Token t, Integer i)
    {
        mem[getArrayIndexFromTokenz(t)]=i;
    }
    public int get(Token t) throws UndefinedVariableException
    {
        Integer integer = mem[getArrayIndexFromTokenz(t)];
        if(integer == null)
            throw new UndefinedVariableException(t);
        return integer;
    }
    //A=65 , Z=90 , a = 97 , z = 122
    private int getArrayIndexFromTokenz(Token t)
    {
        int returnme = t.id;
        if(returnme<91)
            returnme-=65;
        else
            returnme-=97;
        return returnme;
    }  
}