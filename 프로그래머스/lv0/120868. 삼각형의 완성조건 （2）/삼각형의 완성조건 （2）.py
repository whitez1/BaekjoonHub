def solution(sides):
    answer = 0
    ma = max(sides)
    mi = min(sides)
    for i in range(1, ma+1):
        if (mi+i) > ma:
            answer += 1
            
    j = ma + 1
    while(sum(sides)>j):
        answer += 1
        j += 1
    return answer