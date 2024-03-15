import math
def solution(progresses, speeds):
    answer = []
    days = []
    n = len(progresses)
    for i in range(n):
        day = math.ceil((100-progresses[i])/speeds[i])
        days.append(day)
        if days:
            if day <= days[i-1] :
                days[i] = days[i-1]
            else:
                answer.append(days.count(days[i-1]))
        if i == n-1:
            answer.append(days.count(days[i]))        

    return answer