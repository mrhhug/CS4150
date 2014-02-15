mem = [52]

def set(t,i):
    mem[getArrayIndex(t)]=i

def get(t):
    if(t.getCharacter()==null):
        print("integer token expected",t)
        sys.exit(1)
    i = mem[getArrayIndex(t)]
    if(i==null):
        print("undefined variable",t)
        sys.exit(2)
    return i;
    
#A=65 , Z=90 , a = 97 , z = 122
def getArrayIndex(t):
    index = t.getCharacter();
    if(index<91):
        index-=65;
    else:
        index-=97;
    return index;