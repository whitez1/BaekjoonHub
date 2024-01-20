table = [list(map(int, input().split())) for _ in range(9)]
maxval = 0
for i in range(9):
    maxval = max(maxval, max(table[i]))
for i in range(9):
    if maxval in table[i]:
        j = table[i].index(maxval)
        print(maxval)
        print(i+1, j+1)
