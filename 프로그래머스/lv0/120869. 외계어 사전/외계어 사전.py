def solution(spell, dic):    
    for d in dic:
        a = True
        for s in spell:
            if s not in d:
                a = False
                break
        if a == True:
            return 1   
    return 2
                
