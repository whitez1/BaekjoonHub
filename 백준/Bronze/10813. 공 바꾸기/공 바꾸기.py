n, m = map(int, input().split())
bascket = [a for a in range(1, n+1)]
for _ in range(m):
    i, j = map(int, input().split())
    i -= 1
    j -= 1
    bascket[i], bascket[j] = bascket[j], bascket[i]
print(' '.join(list(map(str, bascket))))