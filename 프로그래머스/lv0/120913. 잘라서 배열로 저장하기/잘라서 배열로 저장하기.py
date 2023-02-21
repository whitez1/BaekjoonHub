def solution(my_str, n):
    answer = []
    for i in range((len(my_str)-1)//n + 1):
        answer.append(my_str[i*n: i*n+n])
    return answer