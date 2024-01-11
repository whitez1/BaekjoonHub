n = int(input())
for _ in range(n):
    outword = ""
    r, s = input().split()
    r = int(r)
    for i in range(len(s)):
        outword += s[i]*r
    print(outword)