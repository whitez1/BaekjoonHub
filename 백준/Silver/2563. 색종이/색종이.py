paper = [[0]*100 for _ in range(100)]
n = int(input())
for _ in range(n):
    x, y = map(int, input().split())
    for i in range(10):
        for j in range(10):
            paper[x+i][y+j] = 1
area = 0
for k in paper:
    area += sum(k)
print(area)