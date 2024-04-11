t = int(input())
divisors = sorted(list(map(int, input().split())))
if t == 1:
    print(divisors[0]*divisors[0])
else:
    print(divisors[0]*divisors[-1])