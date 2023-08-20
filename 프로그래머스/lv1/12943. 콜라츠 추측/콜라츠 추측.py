def collatz(num, cnt):
    if num == 1: return cnt
    if cnt == 500: return -1
    if num % 2 == 0: num //= 2
    else: num = num * 3 + 1
    return collatz(num, cnt+1)
    
def solution(num):
    return collatz(num, 0)


    