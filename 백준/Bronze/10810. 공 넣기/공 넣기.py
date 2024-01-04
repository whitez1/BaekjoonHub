n, m = map(int, input().split())
bascket = [0]*n
ball = [list(map(int, input().split())) for _ in range(m)]

for a in range(m):
    i = ball[a][0] - 1
    j = ball[a][1] - 1
    k = ball[a][2]
    for b in range(i, j+1):
        bascket[b] = k

print(' '.join(list(map(str, bascket))))