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
