'''
Author : Michael Hug
Author email : hmichae4@students.kennesaw.edu
Student of Prof Gayler cs4150 Spr014
project - Python
Tuesday, March 25th 2014
'''
class TrashException(RuntimeError):
    def __init__(self, arg):
        self.args = arg

class LexicalException(RuntimeError):
    def __init__(self, arg):
        self.args = arg