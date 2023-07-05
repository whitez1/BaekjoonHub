import math
def solution(a, b):
    b //= math.gcd(a,b)
    for i in range(2, b+1):
        if (i % 2 != 0 and i % 5 != 0):
            if b % i == 0:
                    return 2
    return 1