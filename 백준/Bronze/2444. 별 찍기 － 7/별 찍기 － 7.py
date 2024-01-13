n = int(input())
for i in range(1, 2*n+1, 2):
    print(' '*((2*n-1-i)//2)+'*'*i)
for j in range(2*n-1-2, 0, -2):
    print(' '*((2*n-1-j)//2)+'*'*j)