from itertools import combinations
n, m = map(int, input().split())
lst = list(map(int, input().split()))
lst = sorted(lst, reverse=True)
sumlst = []
for i in combinations(lst, 3):
    if sum(i) <= m:
        sumlst.append(sum(i))
print(max(sumlst))