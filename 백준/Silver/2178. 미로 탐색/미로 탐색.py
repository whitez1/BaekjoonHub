N, M = map(int, input().split())

graph = [list(map(int, list(input()))) for _ in range(N)]

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

visited = [[0]*M for _ in range(N)]

def bfs():
    queue = [[(0, 0), 1]]
    visited[0][0] = 1
    while queue:
        t = queue.pop(0)
        x, y = t[0]
        cnt = t[1]

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < M:
                if graph[nx][ny] == 1:
                    if visited[nx][ny] == 0:
                        queue.append([(nx, ny), cnt + 1])
                        visited[nx][ny] = cnt + 1

bfs()
print(visited[N-1][M-1])


