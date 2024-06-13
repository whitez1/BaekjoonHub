import math
ck = ''
def changeToK(n, k):
    global ck
    if n//k == 0:
        ck += str(n%k)
        return
    changeToK(n//k, k)
    ck += str(n%k)

def solution(n, k):
    global ck
    changeToK(n, k)
    answer = 0
    bin_n = ck.split('0')

    for i in bin_n:
        if i == '' or i == '1':
            continue
        i = int(i)
        for j in range(2, int(i**0.5)+1):
            if i%j==0:
                break
        else: answer += 1 
    return answer