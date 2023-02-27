def solution(my_string):
    answer = 0
    tmp = my_string.split()
    answer += int(tmp[0])
    for i in range(1,len(tmp)+1):
        if i != len(tmp):
            if tmp[i] == '+':
                answer += int(tmp[i+1])
            elif tmp[i] == '-':
                answer -= int(tmp[i+1])
            else:
                continue
    return answer
