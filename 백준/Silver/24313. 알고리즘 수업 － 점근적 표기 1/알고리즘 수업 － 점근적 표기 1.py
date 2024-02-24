a0, a1 = map(int, input().split())
c = int(input())
n0 = int(input())
isOn = True
if c != a0:
    interpoint = a1//(c-a0)
    if a0 > c or n0 < interpoint:
        isOn = False
if isOn:
    print(1)
else:
    print(0)