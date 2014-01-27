package project;

public class memory 
{
    // java initializes string to null
    private final String ddr[] = new String[51];
    
    public void setIdentifier(String letter, String number)
    {
        assert (lexAnal.id(letter));
        assert (lexAnal.literal_integer(number));
        ddr[getArrayIndexFromToken(letter)]=number;
    }
    public void setIdentifier(String letter, int number)
    {
        assert (lexAnal.id(letter));
        ddr[getArrayIndexFromToken(letter)]=Integer.toString(number);
    }
    public int getIdentifier(String letter, int tokenNum)
    {
        assert (lexAnal.id(letter));
        return Integer.parseInt(ddr[getArrayIndexFromToken(letter)]);
    }
    //A=65 , Z=90 , a = 97 , z = 122
    private int getArrayIndexFromToken(String letter)
    {
        assert (lexAnal.id(letter));
        int returnme = (int) letter.charAt(0);
        if(returnme<91)
            returnme-=65;
        else
            returnme-=97;
        return returnme;
    }
}

 
