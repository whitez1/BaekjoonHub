a, b, v = map(int, input().split())

if (v-b) % (a-b) == 0:
    answer = (v-b)//(a-b)
else:
    answer = (v-b)//(a-b) + 1
print(answer)