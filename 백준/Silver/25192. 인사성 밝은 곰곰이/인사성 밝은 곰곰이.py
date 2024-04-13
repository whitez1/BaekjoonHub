import sys
input = sys.stdin.readline
n = int(input())
result = 0
for _ in range(n):
    string = input().rstrip()
    if string == 'ENTER':
        nicknames = {}
    else:
        if nicknames.get(string, -1) == -1:
            nicknames[string] = 1
            result += 1
print(result)