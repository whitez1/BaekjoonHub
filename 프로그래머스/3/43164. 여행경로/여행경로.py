from collections import defaultdict
def dfs(graph, path, visit):
    if path:
        to = path[-1]
        if graph[to]: path.append(graph[to].pop(0))
        else: visit.append(path.pop())
        dfs(graph, path, visit)
        
    return visit[::-1]

def solution(tickets):
    answer = []
    graph = defaultdict(list)
    for departure, arrival in tickets:
        graph[departure].append(arrival)
    for key in graph:
        graph[key].sort()
    return dfs(graph, ["ICN"], [])