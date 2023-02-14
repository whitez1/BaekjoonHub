def solution(num, total):
    answer = []
    for i in range(num):
        answer.append(i + ((total-1)//num + 1) - num//2)
    return answer