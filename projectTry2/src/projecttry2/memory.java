package projecttry2;

public class memory 
{
    // java initializes string to null
    private final String NVRAM[] = new String[51];
    
    public void setIdentifier(token t, token u) throws LiteralIntegerExpectedException, idExpectedException
    {
        if(!lexAnal.id(t.tokentype()))
            throw new idExpectedException(t);
        if(!lexAnal.literal_integer(u.tokentype()))
            throw new LiteralIntegerExpectedException(u);
        NVRAM[getArrayIndexFromToken(t)]=u.tokentype();
    }
    public token getIdentifier(token t) throws LiteralIntegerExpectedException
    {
        return new token(NVRAM[getArrayIndexFromToken(t)],t.getlineNumber(),t.getcolNumber());
    }
    //A=65 , Z=90 , a = 97 , z = 122
    private int getArrayIndexFromToken(token t) throws LiteralIntegerExpectedException
    {
        if(!lexAnal.id(t.tokentype()))
            throw new LiteralIntegerExpectedException(t);
        int returnme = (int) t.tokentype().charAt(0);
        if(returnme<91)
            returnme-=65;
        else
            returnme-=97;
        return returnme;
    }
}

 
