lst = [input() for _ in range(5)]
maxval = 0
for i in lst:
    maxval = max(maxval, len(i))
for i in range(maxval):
    for j in lst:
        if i >= len(j):
            continue
        print(j[i], end='')