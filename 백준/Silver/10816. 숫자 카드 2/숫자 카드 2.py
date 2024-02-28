n = int(input())
nlst = list(map(int, input().split()))
dic = {}
for i in nlst:
    dic[i] = dic.get(i, 0) + 1
m = int(input())
mlst = list(map(int, input().split()))
for j in mlst:
    print(dic.get(j, 0), end=' ')