n = int(input())
sumi = 1
i = 0
while True:
    sumi += 6 * i
    i += 1
    if sumi >= n:
        print(i)
        break
    