from collections import deque

n = int(input())
paper_nums = list(map(int, input().split()))
bal_nums = [i for i in range(1, len(paper_nums) + 1)]
q = deque(list(zip(bal_nums, paper_nums)))
d = 0
while q:
    q.rotate(d)
    bal = q.popleft()
    d = bal[1]*(-1)
    if d < 0: d += 1
    print(bal[0], end = ' ')
