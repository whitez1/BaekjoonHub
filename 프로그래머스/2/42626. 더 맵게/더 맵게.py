import heapq
def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    
    while True:
        x = heapq.heappop(scoville)
        if x >= K: break
        if len(scoville) == 0:
            return -1
        y = heapq.heappop(scoville)
        heapq.heappush(scoville, x+y*2)
        answer += 1
    
    return answer