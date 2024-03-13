import sys
input = sys.stdin.readline
def is_prime(x):
    if x == 1:
        return False
    for i in range(2, int(x**0.5)+1):
        if x % i == 0:
            return False
    return True
end = 123456*2+1
numlst = [0]*end
for i in range(1, end):
    if is_prime(i):
        numlst[i] = 1
while True:
    n = int(input())
    if n == 0:
        break
    cnt = 0
    for i in range(n+1, 2*n+1):
        if numlst[i] == 1:
            cnt += 1
    print(cnt)