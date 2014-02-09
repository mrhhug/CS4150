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
