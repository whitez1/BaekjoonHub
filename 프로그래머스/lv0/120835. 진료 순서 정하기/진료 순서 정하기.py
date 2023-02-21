def solution(emergency):
    answer = []
    reverse_emergency = emergency[:]
    reverse_emergency.sort(key=lambda x: -x)
    dic_emer = dict(zip(reverse_emergency, list(range(1, len(emergency)+1))))
    for i in emergency:
        answer.append(dic_emer[i])
    return answer