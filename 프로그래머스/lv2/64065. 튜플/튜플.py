def solution(s):
    answer = []
    s = s[2:-2]
    temp = s.split('},{')
    lst = []
    for t in temp:
        t = t.split(',')
        t = set(t)
        lst.append(t)
    
    lst = sorted(lst, key=lambda x: len(x))
    
    preset = set()
    for curset in lst:
        oneset = curset-preset
        preset = curset
        answer.append(int(oneset.pop()))
        
    return answer