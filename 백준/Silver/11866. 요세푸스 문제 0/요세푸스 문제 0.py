from collections import deque
n, k = map(int, input().split())
result = []
queue = deque([i for i in range(1, n+1)])
start = 0
while len(queue) != 0:
    queue.rotate(-(k-1))
    result.append(str(queue.popleft()))

result.extend(list(map(str,queue)))
print('<'+', '.join(result)+'>')