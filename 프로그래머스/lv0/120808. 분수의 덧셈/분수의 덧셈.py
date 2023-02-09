def solution(numer1, denom1, numer2, denom2):
    answer = []
    numer = numer1 * denom2 + numer2 * denom1
    denom = denom1 * denom2
    if numer < denom:
        for n in range(numer, 1, -1):
            if denom % n ==0 and numer % n == 0:
                denom /= n
                numer /= n
    else:
        for d in range(denom, 1, -1):
            if denom % d ==0 and numer % d == 0:
                denom /= d
                numer /= d
    answer = [numer, denom]
    return answer