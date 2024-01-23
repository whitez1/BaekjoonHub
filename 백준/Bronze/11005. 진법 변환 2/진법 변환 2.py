def abc(n, b):
    if n//b != 0:
        abc(n//b, b)
    if n%b < 10:
        print(n%b, end='')
    else:
        print(chr(ord('A')+n%b-10), end='')

n, b = map(int, input().split())
abc(n, b)
