def solution(n):
    lst = list(map(int,list(str(n))))
    sum = 0
    for i in lst:
        sum += i
    return sum