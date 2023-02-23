def solution(num, k):
    s = str(num).find(str(k))
    return s+1 if s>=0 else s  