lst = list(map(int, input().split()))
if max(lst) < sum(lst)-max(lst):
    print(sum(lst))
else:
    lst.pop(lst.index(max(lst)))
    print(2*sum(lst)-1)