import math
def solution(n):
    answer = 0
    fact = 0
    i = 1
    while(1):
        fact = math.factorial(i)
        if fact > n:
            break
        i += 1
    return i-1