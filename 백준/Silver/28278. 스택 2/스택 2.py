import sys
n = int(sys.stdin.readline().rstrip())
stack = []
for i in range(n):
    com = sys.stdin.readline().rstrip()
    if len(com) == 1:
        com = int(com)
        if com == 2:
            if stack:
                print(stack.pop())
            else:
                print(-1)
        elif com == 3:
            print(len(stack))
        elif com == 4:
            if stack:
                print(0)
            else:
                print(1)
        elif com == 5:
            if stack:
                print(stack[-1])
            else:
                print(-1)
    else:
        com, num = map(int, com.split())
        stack.append(num)