def factorial(x):
    if x<1:
        return 1
    return x*factorial(x-1)

n, k = map(int, input().split())
result = factorial(n)//(factorial(k)*factorial(n-k))
print(result)