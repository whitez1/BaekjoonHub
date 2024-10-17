import heapq
def solution(operations):
    max_heap = []
    min_heap = []
    heapq.heapify(max_heap)
    heapq.heapify(min_heap)
    
    for op in operations:           
        if op == "D 1":
            if not max_heap: continue
            x = heapq.heappop(max_heap)
            min_heap.pop(min_heap.index(-x))     
        elif op == "D -1":
            if not min_heap: continue
            x = heapq.heappop(min_heap)
            max_heap.pop(max_heap.index(-x)) 
        else:
            num = int(op[2:])
            heapq.heappush(max_heap, -num)
            heapq.heappush(min_heap, num)
            
    if max_heap and min_heap:
        return [-heapq.heappop(max_heap), heapq.heappop(min_heap)]
    else: return [0, 0]