import sys

n = int(input())
lst = []
for i in range(n):
    num = int(sys.stdin.readline())
    lst.append(num)
for j in sorted(lst):
    print(j)