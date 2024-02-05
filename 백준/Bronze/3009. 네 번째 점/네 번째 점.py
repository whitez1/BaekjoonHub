xlst = []
ylst = []
for i in range(3):
    x, y = map(int, input().split())
    if x in xlst:
        xlst.pop(xlst.index(x))
    else:
        xlst.append(x)
    if y in ylst:
        ylst.pop(ylst.index(y))
    else:
        ylst.append(y)
print(xlst[0], ylst[0])