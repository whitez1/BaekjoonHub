def dfs(start):
    if len(s)==m:
        print(' '.join(map(str, s)))
        return
    for i in range(start, n+1):
        s.append(i)
        dfs(i)
        s.pop()

n, m = map(int, input().split())
lst = [i for i in range(1, n+1)]
s = []
dfs(1)