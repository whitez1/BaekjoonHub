from collections import deque
k = int(input())
stack = deque()
for i in range(k):
    n = int(input())
    if n == 0:
        stack.pop()
    else: stack.append(n)
print(sum(stack))