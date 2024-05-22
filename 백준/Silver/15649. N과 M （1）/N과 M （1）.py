from itertools import permutations

n, m = map(int, input().split())
lst = [i+1 for i in range(n)]
for p in permutations(lst, m):
    for j in p:
        print(j, end=" ")
    print()