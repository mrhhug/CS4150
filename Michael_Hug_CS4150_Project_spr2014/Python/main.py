#!/usr/bin/python3
'''
Author : Michael Hug
Author email : hmichae4@students.kennesaw.edu
Student of Prof Gayler cs4150 Spr014
project - Python
Tuesday, March 25th 2014
'''
import sys
from Exceptions import TrashException, LexicalException
from Tokenizer import Tokenize
from lists import lexeme, mem
        
def TokenCheck(c,n):
    if Tokenize.peek(tokenize)[0] in n:
        return Tokenize.pop(tokenize)
    else:
        c = c.__class__.__name__
        t = Tokenize.peek(tokenize)
        raise LexicalException(c+"'s '"+str(n)+"' lexeme expected, found:'%s'. line:%d,column:%d" % (t[0],t[1],t[2]))
    
def getmem(a):
    return mem[ord(a[0])-65 if ord(a[0])<91 else ord(a[0])-71]
    
class program():
    def __init__(self):
        TokenCheck(self,'def')
        cb = code_block()
        TokenCheck(self,'end')
        cb.evalu()

class if_statement():
    def __init__(self):
        TokenCheck(self,'if')
        self.b=boolean_expression()
        TokenCheck(self,'then')
        self.cb=code_block()
        TokenCheck(self,'else')
        self.cb2=code_block()
        TokenCheck(self,'end')        
    def evalu(self):
        if(self.b.evalu()):
            self.cb.evalu()
        else:
            self.cb2.evalu()
    
class code_block():
    def __init__(self):
        self.statementList=[]
        while(self.nexttokenBeginsStatement()):
            pass
    def nexttokenBeginsStatement(self):
        if(Tokenize.peek(tokenize)[0]=='if'):
            self.statementList.append(if_statement())
        elif(Tokenize.peek(tokenize)[0]=='while' or Tokenize.peek(tokenize)[0]=='until'):
            self.statementList.append(loop())
        elif(len(Tokenize.peek(tokenize)[0])==1 and Tokenize.peek(tokenize)[0].isalpha()):
            self.statementList.append(assignment_statement(Tokenize.pop(tokenize)))
        elif(Tokenize.peek(tokenize)[0]=='puts'):
            self.statementList.append(print_statement(Tokenize.pop(tokenize)))
        else:
            return False
        return True;
    def evalu(self):
        for x in self.statementList:
            x.evalu();
    
class assignment_statement():
    def __init__(self,a):
        self.a=a
        TokenCheck(self,'=')
        self.b = expresion()
    def evalu(self):
        mem[ord(self.a[0])-65 if ord(self.a[0])<91 else ord(self.a[0])-71]=self.b.evalu()

class loop():
    def __init__(self):
        self.keyword=TokenCheck(self,lexeme[1])
        self.b=boolean_expression()
        TokenCheck(self,'do')
        self.cb=code_block()
        TokenCheck(self,'end')
    def evalu(self):
        if(self.keyword[0]=="while"):
            while(self.b.evalu()):
                self.cb.evalu()
        else:
            while not (self.b.evalu()):
                self.cb.evalu()
                    
class boolean_expression():
    def __init__(self):
        ro = TokenCheck(self,lexeme[2])
        self.ro=ro
        self.e1=expresion()
        self.e2=expresion()
    def evalu(self):
        if(str(self.ro[0])=="<="):
            return self.e1.evalu() <= self.e2.evalu()
        elif(str(self.ro[0])=="<"):
            return self.e1.evalu() < self.e2.evalu()
        elif(str(self.ro[0])==">"):
            return self.e1.evalu() > self.e2.evalu()
        elif(str(self.ro[0])==">="):
            return self.e1.evalu() >= self.e2.evalu()
        elif(str(self.ro[0])=="=="):
            return self.e1.evalu() == self.e2.evalu()
        elif(str(self.ro[0])=="/="):
            return self.e1.evalu() != self.e2.evalu()
        
class print_statement():
    def __init__(self,*arg):
        self.a=expresion()
    def evalu(self):
        print(self.a.evalu())
        
class expresion():
    def __init__(self):
        self.a = Tokenize.pop(tokenize)
        if not (isinstance(self.a[0],int) or len(self.a[0])==1 and self.a[0].isalpha()):
            self.b = expresion()
            self.c = expresion()
    def evalu(self):
        if(isinstance(self.a[0],int)):
            return self.a[0]
        if(len(self.a[0])==1 and self.a[0].isalpha()):
            return getmem(self.a)
        if(self.a[0]=="+"):
            return self.b.evalu() + self.c.evalu()
        elif(self.a[0]=="-"):
            return self.b.evalu() - self.c.evalu()
        elif(self.a[0]=="*"):
            return self.b.evalu() * self.c.evalu()
        elif(self.a[0]=="/"):
            return self.b.evalu() / self.c.evalu()

if len(sys.argv) < 2:
    print("Please enter the file to interpret as the a command line argument")
else:
    try:  
        tokenize = Tokenize(sys.argv[1])
        program()
    except LexicalException as e:
        print("".join(map(str,e.args)))
    except TrashException as e:
        print("".join(map(str,e.args)))
        
    if Tokenize.pop(tokenize)[0]!= 'EOF':
        raise TrashException("Trash found: at end of program")
