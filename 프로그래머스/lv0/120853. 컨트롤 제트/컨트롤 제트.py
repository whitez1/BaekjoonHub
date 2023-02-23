def solution(s):
    s = s.split()
    while 'Z' in s:
        i = s.index('Z')
        s[i-1: i+1] = []
    s = list(map(int, s))
    return sum(s)