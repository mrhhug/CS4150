mem = [52]
tl = []

class Parser():
    def __init__(self):
        if tl:
            Program()
            
class Program():
    def __init__(self):
        a = tl.pop()
        if(str(a)!="def"):
            print("def keyword expected. line,colum"+str(a.lin)+","+str(a.col))
        b = Code_Block()
        c= tl.pop()
        if(str(c)!="end"):
            print("end keyword expected. line,colum"+str(c.lin)+","+str(c.col))
        b.evalu()
        
class Code_Block():
    def __init__(self):
        self.statementList=[]
        while(self.nexttokenBeginsStatement(tl.pop())):
            pass
    def nexttokenBeginsStatement(self,a):
        if(str(a)=="if"):
            self.statementList.append(if_statement())
        elif(str(a)=="while"):
            self.statementList.append(while_statement())
        elif(str(a)=="id"):
            self.statementList.append(assignment_statement())
        elif(str(a)=="puts"):
            self.statementList.append(Prt())
        elif(str(a)=="until"):
            self.statementList.add(until_statement())
        else:
            return False
        return True;
    def evalu(self):
        for x in self.statementList:
            x.evalu();
    
def set(t,i):
    mem[getArrayIndex(t)]=i

class Token():
    def __init__(self,tok,lin,col):
        self.tok = tok
        self.lin = lin
        self.col = col
    def isInteger(self):
        return isinstance(self.tok,int)
    def isCharacter(self):
        return len(self.tok)==1 and self.tok.isalpha()
    '''def __str__(self):
        return str(self.tok)'''
    def __repr__(self):
        return str(self.tok)
    
class Loop():
    def __init__(self,a):
        self.a=a
        self.b=Bool(tl.pop())
        if(tl.pop()!="then"):
            print("loop messed up. line,colum"+str(a.lin)+","+str(a.col))
        c=Expresion()
        if(tl.pop()!="then"):
            print("loop messed up. line,colum"+str(a.lin)+","+str(a.col))
    def evalu(self):
        if(a.tok=="while"):
            while(b.evalu()):
                c.evalu()
        elif(a.tok=="until"):
            while not (b.evalu()):
                c.evalu()
        else:
           print("loop messed up. line,colum"+str(a.lin)+","+str(a.col)) 
                    
class Bool():
    def __init__(self,a):
        self.a=a
        self.b=Expresion()
        self.c=Expresion()
    def evalu(self):
        if(str(a)=="<="):
            return b.evalu() <= c.evalu()
        if(str(a)=="<"):
            return b.evalu() < c.evalu()
        if(str(a)==">"):
            return b.evalu() > c.evalu()
        if(str(a)==">="):
            return b.evalu() >= c.evalu()
        if(str(a)=="=="):
            return b.evalu() == c.evalu()
        if(str(a)=="/="):
            return b.evalu() != c.evalu()
        print("expresion messed up. line,colum"+str(a.lin)+","+str(a.col))
        
class Prt():
    def __init__(self):
        self.a=Expresion()
    def evalu(self):
        print(self.a.evalu())
        
class Expresion():
    def __init__(self):
        self.a = tl.pop(0)
        if (self.a.isInteger() or self.a.isCharacter()):
            self.b = Expresion()
            self.c = Expresion()
    def evalu(self):
        if(self.a.isInteger()):
            return int(a)
        if(self.a.isCharacter()):
            return mem[self.a.tok-65 if self.a.tok<91 else self.a.tok-71] 
        if(str(self.a)=="+"):
            return self.b.evalu() + self.c.evalu()
        if(str(self.a)=="-"):
            return self.b.evalu() - self.c.evalu()
        if(str(self.a)=="*"):
            return self.b.evalu() * self.c.evalu()
        if(str(self.a)=="/"):
            return self.b.evalu() / self.c.evalu()
        print("expresion messed up. line,colum"+str(self.a.lin)+","+str(self.a.col))
    

            
def tokenize(fileName):
        f = open (fileName,"r")
        data = f.read()
        lin = 1;
        buffer = ""
        col = 1
        for cha in data:
            if(cha.isspace()):
                if(len(buffer)!=0):
                    tl.append(Token(buffer,lin,col))
                buffer = ""
            else:
                buffer+=cha
            if(cha=='\n'):
                lin+=1
                col=0
            col+=1
        f.close()
        #tl.append(Token("EOF",lin,col))
        l = list(tl)
        #print (tl)
        #return tl
tokenize("/home/michael/School/CSCI/CS4150/Michael_Hug_CS4150_Project_spr2014/ruby.rb")
tl.reverse()
Parser()