N, X = map(int, input().split())
lst = list(map(int, input().split()))
for l in lst:
    if l < X:
        print(l, end = ' ')