package static_classes;

import exceptions.RuntimeError;
import lexicalanalyzer.Token;

public class memory
{
    static Integer mem[] = new Integer[52];
    
    public static void set(Token t, Integer i) throws RuntimeError
    {
        if(i==null)
            throw new RuntimeError("no idea how you got here",t);
        mem[getArrayIndex(t)]=i;
    }
    public static Integer get(Token t) throws RuntimeError
    {
        if(t.getCharacter()==null)
            throw new RuntimeError("integer token expected",t);
        Integer i = mem[getArrayIndex(t)];
        if(i==null)
            throw new RuntimeError("undefined variable",t);
        return i;
    }
    //A=65 , Z=90 , a = 97 , z = 122
    private static int getArrayIndex(Token t)
    {
        int index = t.getCharacter();
        if(index<91)
            index-=65;
        else
            index-=97;
        return index;
    }
}
