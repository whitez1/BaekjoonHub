n, m = map(int, input().split())
nset = set()
mset = set()
for i in range(n):
    nset.add(input())
for j in range(m):
    mset.add(input())
re = sorted(list(nset&mset))
print(len(re))
for k in re:
    print(k)