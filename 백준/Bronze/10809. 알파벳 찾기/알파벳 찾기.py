s = input()
alpha = [-1]*26
for i in range(26):
    alpha[i] = s.find(chr(97+i))
print(' '.join(list(map(str, alpha))))