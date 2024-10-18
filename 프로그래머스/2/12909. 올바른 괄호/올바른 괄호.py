def solution(s):
    stack = []
    for p in s:
        if p == '(':
            stack.append('(')
        else:
            if stack: stack.pop()
            else: return False
    if stack:
        return False
    return True