/*
 *Author : Michael Hug
 *Author email : hmichae4@students.kennesaw.edu
 *Student of Prof Gayler cs4150 Spr014
 *Project - Java
 */

package parser;

import exceptions.RuntimeError;

class until_statement extends abstractloop
{
    until_statement() throws RuntimeError 
    {   }

    @Override
    public void evaluate() throws RuntimeError
    {
        while(!be.evaluate())
            cb.evaluate();
    }
}
class while_statement extends abstractloop
{
    while_statement() throws RuntimeError
    {   }
    
    @Override
    public void evaluate() throws RuntimeError
    {
        while(be.evaluate())
            cb.evaluate();
    } 
}