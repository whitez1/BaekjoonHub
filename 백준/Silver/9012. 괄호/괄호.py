t = int(input())

for _ in range(t):
    ps = input()
    stack = []
    isvps = True
    for p in ps:
        if p == ')':
            if stack:
                x = stack.pop()
            else:
                isvps = False
        else:
            stack.append(p)
    if isvps and not stack:
        print('YES')
    elif not isvps or stack:
        print('NO')