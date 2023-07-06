def solution(n):
    lst = []
    i=1
    c=1
    while c<=n:
        if "3" in str(i):
            i+=1
            continue
        if i%3 == 0:
            i+=1
            continue
        lst.append(i)
        i+=1
        c+=1
    return lst[n-1]