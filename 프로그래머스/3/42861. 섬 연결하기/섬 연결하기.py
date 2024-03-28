def solution(n, costs):
    answer = 0
    mat = [[0]*n for _ in range(n)]
    for x, y, c in costs:
        mat[x][y] = c
        mat[y][x] = c
    pre = 10000000
    for i in range(n):
        s = 0
        for  j in range(n):
            s += mat[i][j]
        if pre > s:
            pre = s
        
    return answer