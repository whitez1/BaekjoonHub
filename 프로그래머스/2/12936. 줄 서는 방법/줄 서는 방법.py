import math
def factorial(x):
    if x<1: return 1
    return x*factorial(x-1)

def solution(n, k):
    answer = []
    queue = [i for i in range(1, n+1)]
    k -= 1
    for j in range(n):
        index = k//factorial(n-1)
        answer.append(queue[index])
        queue.pop(index)
        k = k % factorial(n-1)
        n -= 1
    return answer