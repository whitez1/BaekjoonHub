n = int(input())
lst = list(map(int, input().split()))
temp = sorted(list(set(lst)))
index = [i for i in range(len(temp))]
dic = dict(zip(temp, index))
for j in lst:
    print(dic[j], end=' ')
