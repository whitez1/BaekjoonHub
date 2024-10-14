import sys

N, M, V = map(int, sys.stdin.readline().rstrip().split())
graph = [[0]*(N+1) for _ in range(N+1)]
for _ in range(M):
    x, y = map(int, sys.stdin.readline().rstrip().split())
    graph[x][y] = 1
    graph[y][x] = 1
stack = [V]
d_v = [0]*(N+1)
queue = [V]
b_v = [0]*(N+1)
def dfs():
    while stack:
        k = stack.pop()
        if d_v[k] == 0:
            print(k, end=' ')
        d_v[k] = 1
        for l in range(N, -1, -1):
            if d_v[l] == 0 and graph[k][l] == 1:
                stack.append(l)

def bfs():
    while queue:
        k = queue.pop(0)
        if b_v[k] == 0:
            print(k, end=' ')
        b_v[k] = 1
        for l in range(N + 1):
            if b_v[l] == 0 and graph[k][l] == 1:
                queue.append(l)

dfs()
print()
bfs()