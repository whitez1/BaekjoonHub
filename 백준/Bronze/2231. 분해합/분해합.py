n = int(input())
sumpro = 0
answer = 0
for i in range(1, n):
    sumpro += i
    ci = i
    while True:
        if ci==0:
            break
        sumpro += (ci%10)
        ci //= 10
    if sumpro == n:
        answer = i
        break
    sumpro = 0

print(answer)
