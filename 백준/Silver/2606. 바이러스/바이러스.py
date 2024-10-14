V = int(input())
graph = [[0]*(V+1) for _ in range(V+1)]

E = int(input())

for _ in range(E):
    x, y = map(int, input().split())
    graph[x][y] = graph[y][x] = 1

visited = [0] * (V+1)
result = 0

def dfs(x):
    global result
    visited[x] = 1
    for i in range(V+1):
        if graph[x][i] == 1 and visited[i] == 0:
            result += 1
            dfs(i)
dfs(1)
print(result)