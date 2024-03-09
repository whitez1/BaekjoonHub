import sys

def isPrime(x):
    for i in range(2, int(x ** 0.5) + 1):
        if x % i == 0:
            return False
    return True


num = int(sys.stdin.readline().rstrip())
for i in range(num):
    j = int(sys.stdin.readline().rstrip())
    while True:
            if j == 0 or j == 1:
                print(2)
                break
            if isPrime(j):
                print(j)
                break
            j += 1
