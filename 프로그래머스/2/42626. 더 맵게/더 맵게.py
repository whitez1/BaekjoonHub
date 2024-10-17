import heapq
def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    
    while True:
        if len(scoville) == 0:
            answer = -1
            break
        x = heapq.heappop(scoville)
        if x >= K: break
        if len(scoville) == 0:
            answer = -1
            break 
        y = heapq.heappop(scoville)
        heapq.heappush(scoville, x+y*2)
        answer += 1
    
    return answer