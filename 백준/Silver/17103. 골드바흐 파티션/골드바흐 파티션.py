import sys
input = sys.stdin.readline
t = int(input())
primes = [0, 0]+[1]*999999

for i in range(2, 1000001):
    if primes[i] == 1:
        for j in range(i*2, 1000001, i):
            primes[j] = 0

for j in range(t):
    n = int(input())
    cnt = 0
    for k in range(n-2, n//2-1, -1):
        if primes[k] and primes[n-k]:
            cnt += 1
    print(cnt)