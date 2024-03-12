import sys

input = sys.stdin.readline
m, n = map(int, input().split())
for i in range(m, n + 1):
    isprime = True
    if i == 1:
        isprime = False
    for j in range(2, int(i ** 0.5) + 1):
        if i % j == 0:
            isprime = False
            break
    if isprime:
        print(i)
