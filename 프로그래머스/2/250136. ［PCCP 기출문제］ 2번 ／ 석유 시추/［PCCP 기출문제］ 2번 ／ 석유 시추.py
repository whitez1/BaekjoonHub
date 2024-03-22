import sys
sys.setrecursionlimit(10**6)
def dfs(x, y, idx, land):
    global cnt
    x_del = [0, 1, 0, -1]
    y_del = [-1, 0, 1, 0]
    
    land[x][y] = idx
    cnt += 1
       
    for i in range(4):
        nx = x + x_del[i]
        ny = y + y_del[i]
        
        if 0<=nx<n and 0<=ny<m:
            if land[nx][ny] == 1:
                dfs(nx, ny, idx, land)

def solution(land):
    global cnt, n, m
    oil_types = [set() for _ in range(len(land[0]))]
    answer = [0]*len(land[0])
    val = {}
    idx = 2
    n = len(land)
    m = len(land[0])
    
    for i in range(m):
        for j in range(n):
            cnt = 0
            if land[j][i] == 1:
                dfs(j, i, idx, land)
                val[idx] = cnt
                oil_types[i].add(idx)
                idx += 1
            if land[j][i] > 1:
                oil_types[i].add(land[j][i])
                
    for i, oil_nums in enumerate(oil_types):
        for num in oil_nums:
            answer[i] += val[num] 

    return max(answer)