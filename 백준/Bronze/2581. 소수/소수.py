m = int(input())
n = int(input())
prime_sum = 0
prime_list = []
for i in range(m, n+1):
    isprime = True
    for j in range(2, i):
        if i%j == 0:
            isprime = False
            break
    if isprime and i != 1:
        prime_sum += i
        prime_list.append(i)
if prime_sum == 0:
    print(-1)
else:
    print(prime_sum)
    print(prime_list[0])
