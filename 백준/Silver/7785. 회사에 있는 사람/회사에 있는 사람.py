n = int(input())
pre = set()
for i in range(n):
    name, status = input().split()
    if status == 'enter':
        pre.add(name)
    elif status == 'leave':
        pre.remove(name)
pre = sorted(list(pre), reverse = True)
for p in pre:
    print(p)