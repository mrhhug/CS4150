/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package other;

import static goodtry.ArithmeticOperatorEnum.ADD;
import static goodtry.ArithmeticOperatorEnum.DIV;
import static goodtry.ArithmeticOperatorEnum.MUL;
import static goodtry.ArithmeticOperatorEnum.SUB;

/**
 *
 * @author michael
 */
public class code_block
{
    TokenList tl;
    memory mem;
    
    code_block()
    {
        Token t = tl.getNextToken();
        t.
        statement statement = new statement();
    }
    class statement
    {
        Token t = tl.getNextToken();
        t.
        class expression
        {
            Token t = tl.getNextToken();
            Integer i;
            t.
            if(t.li!=null)
                i = t.li;
            else if(t.id!=null)
                i = mem.get(t);
            else if(t.a!=null)
            {
                if(t.a==ADD)
                    i = expression(tl.getNextToken()) + expression(tl.getNextToken());
                if(t.a==SUB)
                    i = expression(tl.getNextToken()) - expression(tl.getNextToken());
                if(t.a==MUL)
                    i = expression(tl.getNextToken()) * expression(tl.getNextToken());
                if(t.a==DIV)
                    i = expression(tl.getNextToken()) / expression(tl.getNextToken());
            }
            else
                throw new ParserException("literal , id or arithmatic operator expected",t);
            return i;
        }
    }
}
