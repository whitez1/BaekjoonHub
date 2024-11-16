from collections import deque

def bfs():
    q = deque()
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    q.append((0, 0))
    visited[0][0] = True

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < N:
                if not visited[nx][ny]:
                    visited[nx][ny] = True
                    time[nx][ny] = time[x][y] + graph[nx][ny]
                    q.append((nx, ny))
                else:
                    if time[nx][ny] > time[x][y] + graph[nx][ny]:
                        time[nx][ny] = time[x][y] + graph[nx][ny]
                        q.append((nx, ny))

T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    graph = list(list(map(int, input())) for _ in range(N))
    time = [[0] * N for _ in range(N)]
    visited = [[False] * N for _ in range(N)]
    bfs()
    answer = time[N-1][N-1]
    print(f"#{test_case} {answer}")