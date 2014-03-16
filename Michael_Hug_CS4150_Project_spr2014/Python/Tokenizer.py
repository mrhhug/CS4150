'''
Author : Michael Hug
Author email : hmichae4@students.kennesaw.edu
Student of Prof Gayler cs4150 Spr014
project - Python
Tuesday, March 25th 2014
'''
from lists import lexeme
from Exceptions import TrashException

class Tokenize():
    def __init__(self,fileName):
        f = open (fileName,"r")
        data = f.read()
        line = 1
        column = 1
        buff = ""
        self.tl = []
        for cha in data:
            if(cha.isspace()):
                if(len(buff)!=0):
                    self.tl.append((self.gettype(buff,line,column)))
                buff = ""
            else:
                buff+=cha
            if(cha=='\n'):
                line+=1
                column=0
            column+=1
        f.close()
        self.tl.append(('EOF',-1,-1))
        
    def gettype(self,buff,line,column):
        if(buff.isdigit()):
            return (int(buff),line,column)
        if(len(buff)==1 and buff.isalpha()):
            return (buff[0],line,column)
        if not (any(buff in _ for _ in lexeme)):
            raise TrashException("Lexical Analyzer fail. Unidentifable token:'%s' found on line:%d,column:%d" % (buff,line,column))
        return (buff,line,column)
        
    def peek(self):
        return self.tl[0]
    
    def pop(self):
        return self.tl.pop(0)
