def solution(numer1, denom1, numer2, denom2):
    answer = []
    numer = numer1 * denom2 + numer2 * denom1
    denom = denom1 * denom2
   
    for n in range(min(numer, denom), 1, -1):
        if denom % n ==0 and numer % n == 0:
            denom /= n
            numer /= n
   
    answer = [numer, denom]
    return answer