def solution(s):
    answer = ''
    exclusive_letters = set(s)
    dic = dict(zip(list(exclusive_letters), [0] * len(exclusive_letters)))
    for i in s:
        if i in exclusive_letters:
            dic[i] += 1
    
    for key, val in dic.items():
        if val == 1:
            answer += key
    lst = list(answer)
    lst.sort()
    answer = ''.join(lst)
    return answer