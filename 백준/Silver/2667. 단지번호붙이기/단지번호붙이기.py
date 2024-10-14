
N = int(input())
graph = [list(map(int,list(input()))) for _ in range(N)]

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

houses = []
cnt = 0

def dfs(x, y, cnt):
    graph[x][y] = 0
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx < 0 or nx >= N or ny < 0 or ny >= N:
            continue

        if graph[nx][ny] == 1:
            cnt = dfs(nx, ny, cnt + 1)
    return cnt

for i in range(N):
    for j in range(N):
        if graph[i][j] == 1:
            cnt += 1
            houses.append(dfs(i, j, 1))

print(cnt)
for h in sorted(houses):
    print(h)