import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
def dfs(x, graph, visited):
    global cnt
    visited[x] = cnt
    graph[x].sort()
    for g in graph[x]:
        if visited[g] == 0:
            cnt += 1
            dfs(g, graph, visited)

n, m, r = map(int, input().split())
graph = [[] for _ in range(n+1)]
visited = [0]*(n+1)

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
cnt = 1
dfs(r, graph, visited)

for i in range(1, n+1):
    print(visited[i])