n = int(input())
nset = set(map(int, input().split()))
m = int(input())
mlst = list(map(int, input().split()))
mset = set(mlst)
inter = mset&nset
for i in mlst:
    if i in inter:
        print(1, end = ' ')
    else:
        print(0, end = ' ')
