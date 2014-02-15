#from Token import Token
from lexicalanalyzer.Token import Token

class Tokenizer():
        
    def tokenize(self, fileName):
        f = open (fileName,"r")
        data = f.read()
        tl = []
        buffer = ""
        lin = 1
        col = 1
        for cha in data:
            if(cha==' ' or cha=='\t' or cha=='\n' or cha=='\r'):
                if(len(buffer)!=0):
                    tl.append(Token(list(buffer),lin,col))
                buffer = ""
            else:
                buffer+=cha
                
            if(cha=='\n' or cha=='\r'):
                    lin+=1
                    col=0
            col+=1
        f.close()
        #tl.append(Token("EOF",lin,col))
        #l = list(tl)
        #print (l)
        return tl