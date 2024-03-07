import math
n = int(input())
intervals = []
trees = []
answer = 0
pre = int(input())
for i in range(n-1):
    a = int(input())
    trees.append(a)
    intervals.append(a-pre)
    pre = a
interval = math.gcd(*intervals)
for j in intervals:
    answer += j//interval-1
print(answer)