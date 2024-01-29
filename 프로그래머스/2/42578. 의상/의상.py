from itertools import combinations
def solution(clothes):
    answer = 1
    cdict = {}

    for name, kind in clothes:
        cdict[kind] = cdict.get(kind, 0) + 1

    for val in cdict.values():
        if val > 1:
            answer *= (val+1)
        else:
            answer *= 2
    
    return answer-1