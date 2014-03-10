'''
Author : Michael Hug
Author email : hmichae4@students.kennesaw.edu
Student of Prof Gayler cs4150 Spr014
project - Python
'''
class TrashException(RuntimeError):
	def __init__(self, arg):
		self.args = arg
		
class MemoryException(RuntimeError):
	def __init__(self, arg):
		self.args = arg
		
class LexicalException(RuntimeError):
	def __init__(self, arg):
		self.args = arg
