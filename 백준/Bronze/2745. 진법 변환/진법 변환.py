lst = input().split()
b = int(lst[1])
n10 = 0
for i, n in enumerate(lst[0][::-1]):
    if n.isalpha():
        n10 += (ord(n)-ord('A')+10)*b**i
    else:
        n10 += int(n) * b ** i
print(n10)