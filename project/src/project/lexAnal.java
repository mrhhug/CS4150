package project;

public class lexAnal
{
    /**
     * Determines if the token is an id
     * uses a regex
     * @param token a String
     * @return true iff the token is an English letter
     */
    public static boolean id(String token)
    {
        boolean returnme = false;
        if(token.matches("[a-zA-Z]"))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the token is a literal integer
     * uses Integer.parseInt
     * @param token a String
     * @return true iff the token an integer  
     */
    public static boolean literal_integer(String token)
    {
        boolean returnme = false;
        try 
        {
            Integer.parseInt(token);
            returnme = true;
        }
        catch( NumberFormatException e ){;}
        return returnme;
    }
    /**
     * Determines if the token is an assignment operator
     * @param token a String
     * @return true iff the token is a =
     */
    public static boolean assignment_operator(String token)
    {
        boolean returnme = false;
        if(token.equals("="))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the token is a less than or equal to operator
     * @param token a String
     * @return true iff the token is a <=
     */
    public static boolean le_operator(String token)
    {
        boolean returnme = false;
        if(token.equals("<="))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the token is a less than operator
     * @param token a String
     * @return true iff the token is a <
     */
    public static boolean lt_operator(String token)
    {
        boolean returnme = false;
        if(token.equals("<"))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the token is a greater than or equal to operator
     * @param token a String
     * @return true iff the token is a >=
     */
    public static boolean ge_operator(String token)
    {
        boolean returnme = false;
        if(token.equals(">="))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the token is a greater than operator
     * @param token a String
     * @return true iff the token is a >
     */
    public static boolean gt_operator(String token)
    {
        boolean returnme = false;
        if(token.equals(">"))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the token is an equal operator
     * @param token a String
     * @return true iff the token is a ==
     */
    public static boolean eq_operator(String token)
    {
        boolean returnme = false;
        if(token.equals("=="))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the token is a not equal operator
     * @param token a String
     * @return true iff the token is a /=
     */
    public static boolean ne_operator(String token)
    {
        boolean returnme = false;
        if(token.equals("/="))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the token is an addition operator
     * @param token a String
     * @return true iff the token is a +
     */
    public static boolean add_operator(String token)
    {
        boolean returnme = false;
        if(token.equals("+"))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the token is a subtraction operator
     * @param token a String
     * @return true iff the token is a -
     */
    public static boolean sub_operator(String token)
    {
        boolean returnme = false;
        if(token.equals("-"))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the token is a multiplication operator
     * @param token a String
     * @return true iff the token is a *
     */
    public static boolean mult_operator(String token)
    {
        boolean returnme = false;
        if(token.equals("*"))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the token is a division operator
     * @param token a String
     * @return true iff the token is a /
     */
    public static boolean div_operator(String token)
    {
        boolean returnme = false;
        if(token.equals("/"))
            returnme = true;
        return returnme;
    }
}
