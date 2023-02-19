def solution(s1, s2):
    answer = 0
    dic_s1 = dict(zip(s1, [0]*len(s1)))
    for i in s2:
        for key, val in dic_s1.items():
            if i == key:
                dic_s1[key] += 1
    return sum(dic_s1.values())