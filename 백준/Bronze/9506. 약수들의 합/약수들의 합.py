while True:
    n = int(input())
    if n == -1:
        break
    divisor_sum = 0
    divisor = []
    for i in range(1, n//2+1):
        if n % i == 0:
            divisor_sum += i
            divisor.append(str(i))
    if divisor_sum == n:
        print(n, '=', ' + '.join(divisor))
    else:
        print(n, 'is NOT perfect.')