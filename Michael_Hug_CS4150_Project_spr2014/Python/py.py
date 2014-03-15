#!/usr/bin/python3

from Exceptions import *

'''
Author : Michael Hug
Author email : hmichae4@students.kennesaw.edu
Student of Prof Gayler cs4150 Spr014
project - Python
'''

mem = ["undefined variable"] * 52
lexeme = (("def","end","if","then","else","while","do","puts","until"),("=","<=","<",">=",">","==","/="),("+","-","*","/"))
tl = []

def getmem(a):
	b = mem[ord(a[0])-65 if ord(a[0])<91 else ord(a[0])-71]
	# this peeks wring token all over and gives wrong error
	if (b=='undefined variable'):
		raise MemoryException
	return b
		
def LexicalLexicalAnalyzerCheck(c,n):
	if tl[0][0]==n:
		return tl.pop(0)
	else:
		raise LexicalException(c.__class__.__name__+"'s '"+n+"' lexeme expected, found:'%s'. line:%d,column:%d" % (tl[0][0],tl[0][1],tl[0][2]))

class Program():
	def __init__(self):
		LexicalLexicalAnalyzerCheck(self,'def')
		b = Code_Block()
		LexicalLexicalAnalyzerCheck(self,'end')
		b.evalu()

class If():
	def __init__(self):
		LexicalLexicalAnalyzerCheck(self,'if')
		self.b=Bool()
		LexicalLexicalAnalyzerCheck(self,'then')
		self.cb=Code_Block()
		LexicalLexicalAnalyzerCheck(self,'else')
		self.cb2=Code_Block()
		LexicalLexicalAnalyzerCheck(self,'end')		
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
		LexicalLexicalAnalyzerCheck(self,'=')
		self.b = Expresion()
	def evalu(self):
		mem[ord(self.a[0])-65 if ord(self.a[0])<91 else ord(self.a[0])-71]=self.b.evalu()

class Loop():
	def __init__(self):
		if (tl[0][0]!='while' and tl[0][0]!='until'):
			LexicalLexicalAnalyzerCheck(self,"'while' or 'until'")
		else:
			a = tl.pop(0)[0]
		self.keyword=a
		self.b=Bool()
		LexicalLexicalAnalyzerCheck(self,'do')
		self.cb=Code_Block()
		LexicalLexicalAnalyzerCheck(self,'end')
	def evalu(self):
		if(self.keyword=="while"):
			while(self.b.evalu()):
				self.cb.evalu()
		else:
			while not (self.b.evalu()):
				self.cb.evalu()
					
class Bool():
	def __init__(self):
		if(tl[0][0] in lexeme[1]):
			ro = tl.pop(0)
		else:
			LexicalLexicalAnalyzerCheck(self,"Relational Operator")
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

	def gettype(buff,line,column):
			try: 
				return (int(buff),line,column)
			except ValueError:
				pass
			if(len(buff)==1 and buff.isalpha()):
				return (buff[0],line,column)
			if not (any(buff in _ for _ in lexeme)):
				raise TrashException("Lexical Analyzer fail. Unidentifable token:'%s' found on line:%d,column:%d" % (buff,line,column))
			return (buff,line,column)
			   
def Tokenize(fileName):
		f = open (fileName,"r")
		data = f.read()
		line = 1
		buff = ""
		column = 1
		for cha in data:
			if(cha.isspace()):
				if(len(buff)!=0):
					tl.append((gettype(buff,line,column)))
				buff = ""
			else:
				buff+=cha
			if(cha=='\n'): #windows files use something else... DosToUnix if needed
				line+=1
				column=0
			column+=1
		f.close()
		
Tokenize("./../ruby.rb")
Program()
if tl:
	raise TrashException("Trash found:'%s'. line:%d,column:%d" % (tl[0][0],tl[0][1],tl[0][2]))
	
 

	
	
