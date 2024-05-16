from collections import deque
def solution(board):
    N = len(board)
    paths = [(-1, 0), (0, -1), (0, 1), (1, 0)]
    
    def bfs(x, y, cost, path):
        visited = [[0]*N for _ in range(N)]
    
        queue = deque()
        queue.append((x, y, cost, path))
    
        while queue:
            x, y, cost, path = queue.popleft()

            for i in range(len(paths)):
                nx = x + paths[i][0]
                ny = y + paths[i][1]
                
                if 0<=nx<N and 0<=ny<N and board[nx][ny]!=1:
                    if path == i: newcost = cost + 100
                    else: newcost = cost + 600
                        
                    if visited[nx][ny]==0 or (visited[nx][ny]!=0 and visited[nx][ny]>newcost):    
                        queue.append((nx, ny, newcost, i))
                        visited[nx][ny] = newcost
    
        return visited[N-1][N-1]
    
    return min(bfs(0, 0, 0, 2), bfs(0, 0, 0, 3))