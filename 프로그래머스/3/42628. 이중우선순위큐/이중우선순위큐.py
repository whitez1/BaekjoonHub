import heapq
def solution(operations):
    answer = []
    max_heap = []
    min_heap = []
    heapq.heapify(max_heap)
    heapq.heapify(min_heap)
    
    for op in operations: 
        if op[0] == 'I':
            c, num = op.split()
            num = int(num)
            heapq.heappush(max_heap, -1*num)
            heapq.heappush(min_heap, num)
        elif op == "D 1":
            if not max_heap: continue
            x = heapq.heappop(max_heap)
            min_heap.pop(min_heap.index(-1*x))
            
        else:
            if not min_heap: continue
            x = heapq.heappop(min_heap)
            max_heap.pop(max_heap.index(-1*x))
            
    if max_heap and min_heap:
        return [-1*heapq.heappop(max_heap), heapq.heappop(min_heap)]
    else: return [0, 0]