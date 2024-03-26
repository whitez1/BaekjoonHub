n = int(input())
stack = []
people = list(map(int, input().split()))
cnt = 1
result = True
i = 0
while i < len(people):
    p = people[i]
    if cnt == p:
        cnt += 1
    else:
        if stack:
            if cnt == stack[-1]:
                stack.pop()
                i -= 1
                cnt += 1
            elif stack[-1] > p:
                stack.append(p)
            else:
                break
        else:
            stack.append(p)
    i += 1
while stack and stack[-1]==cnt:
    stack.pop()
    cnt += 1
if not stack: print("Nice")
else: print("Sad")