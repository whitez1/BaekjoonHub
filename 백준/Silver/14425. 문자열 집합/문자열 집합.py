n, m = map(int, input().split())
s = []
count = 0
for i in range(n):
    s.append(input())
for j in range(m):
    word = input()
    if word in s:
        count += 1
print(count)
    