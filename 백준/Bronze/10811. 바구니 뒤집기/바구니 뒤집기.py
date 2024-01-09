n, m = map(int, input().split())
bascket = [str(i+1) for i in range(n)]
for _ in range(m):
    i, j = map(int, input().split())
    i -= 1
    j -= 1
    for x in range((j-i)//2+1):
        bascket[i+x], bascket[j-x] = bascket[j-x], bascket[i+x]

print(' '.join(bascket))