from collections import deque
def solution(priorities, location):
    q = deque(list(zip([i for i in range(len(priorities))], priorities)))
    
    ex = []
    while q:
        ci, cp = q.popleft()
        isEx = True
        for i, p in q:
            if cp < p:
                q.append([ci, cp])
                isEx = False
                break
        if isEx: ex.append(ci)
    return ex.index(location)+1