n = int(input())
xlst = []
ylst = []
for _ in range(n):
    x, y = map(int, input().split())
    xlst.append(x)
    ylst.append(y)
if n == 1:
    print(0)
else:
    print((max(xlst)-min(xlst))*(max(ylst)-min(ylst)))