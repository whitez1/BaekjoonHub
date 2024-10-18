def solution(bridge_length, weight, truck_weights):
    answer = 0 
    pq = []
    cq = []
    
    tl = len(truck_weights)
    answer = 1
    while len(cq)!=0 or len(truck_weights)!=0:
        if cq:
            if cq[0][1] == 0:
                pq.append(cq.pop(0))
        if truck_weights:
            if sum(k[0] for k in cq) + truck_weights[0] <= weight:
                cq.append([truck_weights.pop(0), bridge_length])
        if cq:
            for j in cq:
                j[1] -= 1            
        answer += 1  
    return answer-1