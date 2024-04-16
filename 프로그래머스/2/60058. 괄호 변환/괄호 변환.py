def isRight(string):
    stack = []
    for s in string:
        if s == '(':
            stack.append(1)
        else:
            if stack:
                stack.pop()
            else:
                return False
    if stack: return False
    return True 
def split(p):
    pdic = {'(':0, ')':0}
    k = 0
    for i in range(len(p)):
        pdic[p[i]] += 1
        if pdic['(']==pdic[')']:
            k = i
            break
    u = p[:k+1]        
    v = p[k+1:]
    return [u, v]
def step(p):
    if p == "":
        return p
    uv = split(p)
    u = uv[0]
    v = uv[1]
    if isRight(u):
        return u + step(v)
    else:
        string=""
        string += '('
        string += step(v)
        string += ')'
        for i in u[1:-1]:
            if '(' == i: string += ')'
            else: string += '('
        return string


def solution(p):
        
    return step(p)