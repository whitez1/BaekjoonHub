import math

def solution(fees, records):
    answer = []
    fare = {}
    infos = {}
    
    for record in records:
        time, num, state = record.split()
        hour, min_ = map(int, time.split(':'))
        time = hour*60 + min_
        if state == "IN":    
            if infos.get(num, "발견하지 못함") == "발견하지 못함":
                infos[num] = [time, state, 0]
            else:
                infos[num][0] = time
                infos[num][1] = state
        else :
            accu = infos[num][2] + time - infos[num][0]
            infos[num] = [time, state, accu]
            
    for key, value in infos.items():
        if value[1] == "IN":
            infos[key][2] += 23*60+59 - infos[key][0]

    for key, value in infos.items():
        if value[2] <= fees[0]:
            fare[key] = fees[1]
        else:
            fare[key] = fees[1] + math.ceil((value[2]-fees[0])/fees[2])*fees[3]
          
    a = sorted(fare.items())
    for i in a:
        answer.append(i[1])
    return answer