import sys
def fibo(n):
    if n < 2:
        return n
    return fibo(n-1) + fibo(n-2)
n = int(sys.stdin.readline())
print(fibo(n))