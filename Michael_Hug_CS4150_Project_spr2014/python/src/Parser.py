class Parser():
    
    def __init__(self,tl):
        if(tl[0]=="def" and tl[len(tl)]=="end"):
            print("we have a winner")