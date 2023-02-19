import math
def solution(n):
    answer = 0
    for i in range(1, int(math.sqrt(n))+1):
        if n%i==0:
            answer += 1
    return answer*2-1 if math.sqrt(n) == int(math.sqrt(n)) else answer*2