'''
Author : Michael Hug
Author email : hmichae4@students.kennesaw.edu
Student of Prof Gayler cs4150 Spr014
Assignment 2
'''
class book(object):

	def __init__(self, b):
		self.data=b

	def __str__(self):
		return self.data[0]+" wrote '"+self.data[1]+"' in "+str(self.data[2])+" succinct pages."
