def solution(n):
    answer = []
    is_prime = True
    for i in range(2, n+1):
        if n%i == 0:
            for j in range(2, int(i**0.5)+1):
                if i%j == 0:
                    is_prime = False
                    break
            if is_prime and i not in answer:
                answer.append(i)
            is_prime = True
    return answer