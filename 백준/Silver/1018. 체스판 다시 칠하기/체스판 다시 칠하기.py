m, n = map(int, input().split())
kernel1 = ["WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW"]
kernel2 = ["BWBWBWBW", "WBWBWBWB","BWBWBWBW", "WBWBWBWB","BWBWBWBW", "WBWBWBWB","BWBWBWBW", "WBWBWBWB"]
min1 = 0
min2 = 0
min1lst = []
min2lst = []
rectangle = []
for i in range(m):
    rectangle.append(input())
for j in range(m-8+1):
    for k in range(n-8+1):
        for x in range(8):
            for y in range(8):
                if rectangle[j+x][k+y] == kernel1[x][y]:
                    min1 += 1
                if rectangle[j+x][k+y] == kernel2[x][y]:
                    min2 += 1
        min1lst.append(min1)
        min2lst.append(min2)
        min1 = 0
        min2 = 0
print(min(min(min1lst), min(min2lst)))
