from collections import deque
def solution(n, edge):
    answer = 0
    route = [0]*(n+1)
    graph = [[] for i in range(n+1)]
    for e in edge:
        graph[e[0]].append(e[1])
        graph[e[1]].append(e[0])
    visited = []
    queue = deque()
    queue.append(1)
    route[1] = 1
    cntdic = dict()
    while queue:
        cur = queue.popleft()
        for des in graph[cur]:
            if route[des] == 0:
                queue.append(des)
                route[des] = route[cur] + 1
                    
    maxcnt = max(route)
    for r in route:
        if r == maxcnt:
            answer += 1
            
    return answer