from collections import defaultdict
def solution(array):
    maxval = 0
    max_count = 0
    answer = 0
    num_dic = defaultdict()
    for n in list(set(array)):
        num_dic[n] = array.count(n)
        if array.count(n) > maxval:
            maxval = array.count(n)
            answer = n
    for key, val in num_dic.items():
        if num_dic[key] == maxval:
            max_count += 1
    if max_count > 1:
        answer = -1
    return answer