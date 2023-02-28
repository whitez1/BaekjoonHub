def solution(quiz):
    return ["O" if eval(i[:i.index('=')]) == int(i[i.index('=')+2:]) else "X" for i in quiz]