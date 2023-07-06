def solution(numlist, n):
    answer = []
    numdict = dict()
    
    for k in numlist:
        temp = k - n
        if temp < 0:
            temp = temp*(-1) + 0.5
        numdict[temp] = k
    
    numlist_sort = sorted(numdict.keys())
    
    for i in numlist_sort:
        answer.append(numdict[i])

    return answer