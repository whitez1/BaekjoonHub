import sys, math
input = sys.stdin.readline
result = 0
H, W, N, M = map(int, input().split())
ra, rb = 1, 1
if M <= (W-2): ra = math.ceil(W/(M+1))
if N <= (H-2): rb = math.ceil(H/(N+1))
result = ra*rb
print(result)