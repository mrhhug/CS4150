package other;

public class lexAnal
{
    /**
     * Determines if the s is an id
     * uses a regex
     * @param s a String
     * @return true iff the s is an English letter
     */
    public static boolean id(String s)
    {
        boolean returnme = false;
        if(s.matches("[a-zA-Z]"))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the s is a literal integer
     * uses Integer.parseInt
     * @param s a String
     * @return true iff the s an integer  
     */
    public static boolean literal_integer(String s)
    {
        boolean returnme = false;
        try 
        {
            Integer.parseInt(s);
            returnme = true;
        }
        catch( NumberFormatException e ){;}
        return returnme;
    }
    /**
     * Determines if the s is an assignment operator
     * @param s a String
     * @return true iff the s is a =
     */
    public static boolean assignment_operator(String s)
    {
        boolean returnme = false;
        if(s.equals("="))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the s is a less than or equal to operator
     * @param s a String
     * @return true iff the s is a <=
     */
    public static boolean le_operator(String s)
    {
        boolean returnme = false;
        if(s.equals("<="))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the s is a less than operator
     * @param s a String
     * @return true iff the s is a <
     */
    public static boolean lt_operator(String s)
    {
        boolean returnme = false;
        if(s.equals("<"))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the s is a greater than or equal to operator
     * @param s a String
     * @return true iff the s is a >=
     */
    public static boolean ge_operator(String s)
    {
        boolean returnme = false;
        if(s.equals(">="))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the s is a greater than operator
     * @param s a String
     * @return true iff the s is a >
     */
    public static boolean gt_operator(String s)
    {
        boolean returnme = false;
        if(s.equals(">"))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the s is an equal operator
     * @param s a String
     * @return true iff the s is a ==
     */
    public static boolean eq_operator(String s)
    {
        boolean returnme = false;
        if(s.equals("=="))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the s is a not equal operator
     * @param s a String
     * @return true iff the s is a /=
     */
    public static boolean ne_operator(String s)
    {
        boolean returnme = false;
        if(s.equals("/="))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the s is an addition operator
     * @param s a String
     * @return true iff the s is a +
     */
    public static boolean add_operator(String s)
    {
        boolean returnme = false;
        if(s.equals("+"))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the s is a subtraction operator
     * @param s a String
     * @return true iff the s is a -
     */
    public static boolean sub_operator(String s)
    {
        boolean returnme = false;
        if(s.equals("-"))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the s is a multiplication operator
     * @param s a String
     * @return true iff the s is a *
     */
    public static boolean mult_operator(String s)
    {
        boolean returnme = false;
        if(s.equals("*"))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the s is a division operator
     * @param s a String
     * @return true iff the s is a /
     */
    public static boolean div_operator(String s)
    {
        boolean returnme = false;
        if(s.equals("/"))
            returnme = true;
        return returnme;
    }
}
