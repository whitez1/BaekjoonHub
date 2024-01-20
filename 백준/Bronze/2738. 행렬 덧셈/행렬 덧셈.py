n, m = map(int, input().split())
matrix1 = [list(map(int, input().split())) for _ in range(n)]
matrix2 = [list(map(int, input().split())) for _ in range(n)]
matrixs = [[0]*m for _ in range(n)]
for i in range(n):
    for j in range(m):
        matrixs[i][j] = matrix1[i][j] + matrix2[i][j]
for i in range(n):
    print(" ".join(map(str, matrixs[i])))