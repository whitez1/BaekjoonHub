count = input()
str = input()
lst = list(map(int, list(str)))
sum=0
for i in lst:
    sum += i
print(sum)