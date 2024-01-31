n = int(input())
numlst = list(map(int, input().split()))
answer = 0

for num in numlst:
    isprime = True
    for i in range(2, num):
        if num % i == 0:
            isprime = False
            break
    if isprime == True and num != 1:
        answer += 1
print(answer)