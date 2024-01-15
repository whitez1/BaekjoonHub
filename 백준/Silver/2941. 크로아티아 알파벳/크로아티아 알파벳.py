word = input()
cnt = 0
p = 0
alpha3 = 'dz='
alpha2 = ['c=', 'c-', 'd-', 'lj', 'nj', 's=', 'z=']
while p <= len(word)-1:
    if word[p:p+2] in alpha2:
        p += 1
    elif word[p:p+3] == alpha3:
        p += 2
    cnt += 1
    p += 1
print(cnt)
        