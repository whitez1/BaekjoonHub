n = input()
l = [int(i) for i in n]
print(''.join(list(map(str, sorted(l, reverse=True)))))