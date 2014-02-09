/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package parser;

import static_classes.tl;
import exceptions.RuntimeError;

public class Parser
{
    public Parser() throws RuntimeError
    {
        while(tl.peek().getKeyword()!=enumerated_lists.Keyword.EOF)
            new Program();
    }
}
