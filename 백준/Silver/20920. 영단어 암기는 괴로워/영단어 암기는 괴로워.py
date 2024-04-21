import sys
from collections import defaultdict
input = sys.stdin.readline

n, m = map(int, input().split())
fre = defaultdict(int)
for _ in range(n):
    word = input().rstrip()
    if len(word) >= m:
        fre[word] += 1
fre = sorted(fre.items(), key = lambda x: [-x[1], -len(x[0]), x[0]])
for word, cnt in fre:
    print(word)
