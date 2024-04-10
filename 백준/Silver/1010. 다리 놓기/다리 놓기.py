def factorial(x):
    if x<1: return 1
    return x*factorial(x-1)

t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    print(factorial(m)//(factorial(n)*factorial(m-n)))