n = int(input())
rainbow = set()
for _ in range(n):
    a, b = input().split()
    if a == 'ChongChong' or b == 'ChongChong':
        rainbow.add(a)
        rainbow.add(b)
    elif a in rainbow:
        rainbow.add(b)
    elif b in rainbow:
        rainbow.add(a)
print(len(rainbow))