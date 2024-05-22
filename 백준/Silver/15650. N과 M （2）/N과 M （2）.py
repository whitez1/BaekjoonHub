def dfs():
    if len(stack) == m:
        print(' '.join(map(str, stack)))
        return
    for i in range(1, n+1):
        if visited[i]:
            continue
        if stack:
            if stack[-1] > i:
                continue
        visited[i]=1
        stack.append(i)
        dfs()
        stack.pop()
        visited[i]=0

n, m = map(int, input().split())
visited = [0]*(n+1)
stack = []
dfs()
