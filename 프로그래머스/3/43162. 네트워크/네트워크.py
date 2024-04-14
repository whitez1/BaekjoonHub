def solution(n, computers):
    answer = 0
    stack = []
    visited = []
    for i in range(n):
        if len(visited) == n:
            break
        if i not in visited:
            stack.append(i)
            while stack:
                x = stack.pop()
                if x not in visited:
                    visited.append(x)
                for idx, computer in enumerate(computers[x]):
                    if idx not in visited and computer == 1:
                        stack.append(idx)
            answer += 1
    
    return answer