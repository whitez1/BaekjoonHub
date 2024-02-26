import sys
n, m = map(int, sys.stdin.readline().strip().split())
lst = []
dic = {}
for i in range(1, n+1):
    name = sys.stdin.readline().strip()
    lst.append(name)
    dic[name] = i
for j in range(m):
    problem = sys.stdin.readline().strip()
    if problem.isdigit():
        print(lst[int(problem)-1])
    else:
        print(dic[problem])