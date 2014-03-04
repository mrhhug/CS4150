#!/usr/bin/python3
'''
Author : Michael Hug
Author email : hmichae4@students.kennesaw.edu
Student of Prof Gayler cs4150 Spr014
Assignment 2
'''

mem = ["undefined variable"] * 52
lexeme = [("def","end","if","then","else","while","do","puts","until"),("=","<=","<",">=",">","==","/="),("+","-","*","/")]
tl = []


#
# reverse list and omit the number on the pop
#

def getmem(a):
	b = mem[ord(a[0])-65 if ord(a[0])<91 else ord(a[0])-71]
	# this peeks wring token all over and gives wrong error
	assert(b!='undefined variable'), "undefined variable "+exceptshion()
	return b

class TestFailed(Exception):
    def __init__(self, m):
        self.message = m
    def __str__(self):
        return self.message
        
def exceptshion(err):
	print (err+" expected, found:'%s'. line:%d,column:%d" % (tl[0][0],tl[0][1],tl[0][2]))
	assert (False)

class Program(object):
	def __init__(self):
		tl.pop(0)[0] if tl[0][0]=='def' else TestFailed("Program's 'def' keyword")
		b = Code_Block()
		tl.pop(0)[0] if tl[0][0]=='end' else exceptshion("Program's 'end' keyword")
		b.evalu()

class If():
	def __init__(self):
		tl.pop(0) # assert this
		self.b=Bool()
		tl.pop(0)[0] if tl[0][0]=='then' else exceptshion("If's 'then' keyword")
		self.cb=Code_Block()
		tl.pop(0)[0] if tl[0][0]=='else' else exceptshion("If's 'else' keyword")
		self.cb2=Code_Block()
		tl.pop(0)[0] if tl[0][0]=='end' else exceptshion("If's 'end' keyword")
	def evalu(self):
		if(self.b.evalu()):
			self.cb.evalu()
		else:
			self.cb2.evalu()
	
class Code_Block():
	def __init__(self):
		self.statementList=[]
		while(self.nexttokenBeginsStatement()):
			pass
	def nexttokenBeginsStatement(self):
		if(tl[0][0]=='if'):
			self.statementList.append(If())
		elif(tl[0][0]=='while' or tl[0][0]=='until'):
			self.statementList.append(Loop())
		elif(len(tl[0][0])==1 and tl[0][0].isalpha()):
			self.statementList.append(Assi(tl.pop(0)))
		elif(tl[0][0]=='puts'):
			self.statementList.append(Prt(tl.pop(0)))
		else:
			return False
		return True;
	def evalu(self):
		for x in self.statementList:
			x.evalu();
	
class Assi():
	def __init__(self,a):
		self.a=a
		tl.pop(0)[0] if tl[0][0]=='=' else exceptshion("Assignment's '=' keyword")
		self.b = Expresion()
	def evalu(self):
		mem[ord(self.a[0])-65 if ord(self.a[0])<91 else ord(self.a[0])-71]=self.b.evalu()

class Loop():
	def __init__(self):
		a = tl.pop(0) if (tl[0][0]=='while' or tl[0][0]=='until') else exceptshion("Loop's 'while' or 'until' keyword")
		assert (a[0]=='while' or a[0]=='until'),"while or until keyword "+exceptshion("d")
		self.keyword=a
		self.b=Bool()
		assert (tl.pop(0)[0]=='do'),"do keyword "+exceptshion()
		self.cb=Code_Block()
		assert (tl.pop(0)[0]=='end'),"end keyword "+exceptshion()
	def evalu(self):
		if(self.keyword=="while"):
			while(self.b.evalu()):
				self.cb.evalu()
		else:
			while not (self.b.evalu()):
				self.cb.evalu()
					
class Bool():
	def __init__(self):
		ro = tl.pop(0)
		#print (ro)
		assert(10<=lexeme.index(ro[0])<=15 ),exceptshion("Boolean's relational operator")
		self.ro=ro
		self.e1=Expresion()
		self.e2=Expresion()
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
		
class Prt():
	def __init__(self,*arg):
		self.a=Expresion()
	def evalu(self):
		print(self.a.evalu())
		
class Expresion():
	def __init__(self):
		self.a = tl.pop(0)
		if not (isinstance(self.a[0],int) or len(self.a[0])==1 and self.a[0].isalpha()):
			self.b = Expresion()
			self.c = Expresion()
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
		assert (False),str(self.a.tok)+"expresion messed up. "+exceptshion()

def gettype(buffer,line,column):
		try: 
			return (int(buffer),line,column)
		except ValueError:
			pass
		if(len(buffer)==1 and buffer.isalpha()):
			return (buffer[0],line,column)
		assert (any(buffer in _ for _ in lexeme)),"Lexical Analyzer fail. Unidentified token:'%s' found on line:%d,column:%d" % (buffer,line,column)
		return (buffer,line,column)
			   
def Tokenize(fileName):
		f = open (fileName,"r")
		data = f.read()
		line = 1;
		buffer = ""
		column = 1
		for cha in data:
			if(cha.isspace()):
				if(len(buffer)!=0):
					tl.append((gettype(buffer,line,column)))
				buffer = ""
			else:
				buffer+=cha
			if(cha=='\n'): #windows files use something else... DosToUnix if needed
				line+=1
				column=0
			column+=1
		f.close()
		
Tokenize("./../ruby.rb")
while tl:
	Program()
	
 

	
	
