from collections import defaultdict

def solution(id_list, report, k):
    answer = [0]*len(id_list)
    id_list = dict(zip(id_list, [i for i in range(len(id_list))]))
    dic = defaultdict(set)
    for r in report:
        x, y = r.split()
        dic[y].add(x)
    for key in dic:
        if len(dic[key])>=k:
            for val in dic[key]:
                answer[id_list[val]] += 1
    return answer