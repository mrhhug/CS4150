class Token():
    
    tok = []
    lin = -1
    col = -1
    
    def __init__(self,tok,lin,col):
        self.tok = tok
        self.lin = lin
        self.col = col
    
    def isArithmeticOperator(self):
        if(tok=='ADD' or tok=='SUB' or tok=='MUL' or tok=='DIV'):
            return true
        return false
        
    def isKeyword(self):
        if(tok=='ASSIGN' or tok=='EOF' or tok=='DEF' or tok=='END' or tok=='IF' or tok=='THEN' or tok=='ELSE' or tok=='WHILE' or tok=='DO' or tok=='PUTS' or tok=='UNTIL' or tok=='END'):
            return true
        return false
        
    def isRelationOperator(self):
        if(tok=='LE' or tok=='LT' or tok=='GE' or tok=='GT' or tok=='EQ' or tok=='NE'):
            return true
        return false
        
    def isInteger(self):
        return isinstance( tok, int )
    
    def isCharacter(self):
        if (len( str )==1):
            return true
        return false
    
    def __str__(self):
        return "token"+str(self.tok)+"line"+str(self.lin)+"col"+str(self.col)
    
    def __repr__(self):
        return self.__str__()