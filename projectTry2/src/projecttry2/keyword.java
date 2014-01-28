package projecttry2;

//used capital lettes because java wanted to interpret some method names as java reserved words
public class keyword
{
    /**
     * Determines if the token is the keyword def
     * uses String.equals
     * @param token a String
     * @return true iff the token is the keyword def
     */
    public static boolean Def(String token)
    {
        boolean returnme = false;
        if(token.equals("def"))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the token is the keyword end
     * uses String.equals
     * @param token a String
     * @return true iff the token is the keyword end
     */
    public static boolean End(String token)
    {
        boolean returnme = false;
        if(token.equals("end"))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the token is the keyword if
     * uses String.equals
     * @param token a String
     * @return true iff the token is the keyword if
     */
    public static boolean If(String token)
    {
        boolean returnme = false;
        if(token.equals("if"))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the token is the keyword then
     * uses String.equals
     * @param token a String
     * @return true iff the token is the keyword then
     */
    public static boolean Then(String token)
    {
        boolean returnme = false;
        if(token.equals("then"))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the token is the keyword else
     * uses String.equals
     * @param token a String
     * @return true iff the token is the keyword else
     */
    public static boolean Else(String token)
    {
        boolean returnme = false;
        if(token.equals("def"))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the token is the keyword while
     * uses String.equals
     * @param token a String
     * @return true iff the token is the keyword while
     */
    public static boolean While(String token)
    {
        boolean returnme = false;
        if(token.equals("while"))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the token is the keyword do
     * uses String.equals
     * @param token a String
     * @return true iff the token is the keyword do
     */
    public static boolean Do(String token)
    {
        boolean returnme = false;
        if(token.equals("do"))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the token is the keyword puts
     * uses String.equals
     * @param token a String
     * @return true iff the token is the keyword puts
     */
    public static boolean Puts(String token)
    {
        boolean returnme = false;
        if(token.equals("puts"))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the token is the keyword until
     * uses String.equals
     * @param token a String
     * @return true iff the token is the keyword until
     */
    public static boolean Until(String token)
    {
        boolean returnme = false;
        if(token.equals("until"))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the token is a keyword used to begin statements
     * @param token a String
     * @return true iff the token is the keyword is [if,while,puts,English letter]
     */
    public static boolean isStatement(String token)
    {
        boolean returnme = false;
        if(keyword.If(token))
            returnme = true;
        else if(keyword.While(token))
            returnme = true;
        else if(keyword.Puts(token))
            returnme = true;
        else if(keyword.Until(token))
            returnme = true;
        else if(lexAnal.id(token))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the token is a keyword
     * @param token a String
     * @return true iff the token is a keyword
     */
    public static boolean isKeyword(String token)
    {
        boolean returnme = false;
        if(keyword.Def(token))
            returnme = true;
        else if(keyword.End(token))
            returnme = true;
        else if(keyword.If(token))
            returnme = true;
        else if(keyword.Then(token))
            returnme = true;
        else if(keyword.Else(token))
            returnme = true;
        else if(keyword.While(token))
            returnme = true;
        else if(keyword.Do(token))
            returnme = true;
        else if(keyword.Puts(token))
            returnme = true;
        else if(keyword.Until(token))
            returnme = true;
        return returnme;
    }
    /**
     * Determines if the token is a lexeme
     * @param token a String
     * @return true iff the token is a lexeme
     */
    public static boolean isLexeme(String token)
    {
        boolean returnme = false;
        if(lexAnal.id(token))
            returnme = true;
        else if(lexAnal.literal_integer(token))
            returnme = true;
        else if(lexAnal.assignment_operator(token))
            returnme = true;
        else if(lexAnal.le_operator(token))
            returnme = true;
        else if(lexAnal.lt_operator(token))
            returnme = true;
        else if(lexAnal.ge_operator(token))
            returnme = true;
        else if(lexAnal.gt_operator(token))
            returnme = true;
        else if(lexAnal.eq_operator(token))
            returnme = true;
        else if(lexAnal.ne_operator(token))
            returnme = true;
        else if(lexAnal.add_operator(token))
            returnme = true;
        else if(lexAnal.sub_operator(token))
            returnme = true;
        else if(lexAnal.mult_operator(token))
            returnme = true;
        else if(lexAnal.div_operator(token))
            returnme = true;
        return returnme;
    }
}
