def solution(lines):
    answer = 0
    lst = []
    for i in range(3):
        lst.append(set([k for k in range(lines[i][0], lines[i][-1]+1)]))
    print(lst)
    d = sorted(list(lst[0]&lst[2])) if len(list(lst[0]&lst[2]))>1 else [0,0] 
    e = sorted(list(lst[1]&lst[2])) if len(list(lst[1]&lst[2]))>1 else [0,0]
    f = sorted(list(lst[0]&lst[1])) if len(list(lst[0]&lst[1]))>1 else [0,0]
    g = sorted(list(lst[0]&lst[1]&lst[2])) if len(list(lst[0]&lst[1]&lst[2]))>1 else [0,0] 
    print(d, e, f, g)
    if f == g:
        f = [0,0]
    answer = d[-1] - d[0] + e[-1] - e[0] + f[-1] - f[0] - (g[-1] - g[0])
    return answer