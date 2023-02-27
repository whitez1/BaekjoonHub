def solution(bin1, bin2):
    lst = []
    ib1 = list(map(int, list(bin1)))
    ib2 = list(map(int, list(bin2)))
    l=len(bin1)-len(bin2)
    if l>0:
        for i in range(l):
            ib2.insert(i, 0)
    elif l<0:
        for i in range(abs(l)):
            ib1.insert(i, 0)
    
    for i in range(len(ib1)-1, -1, -1):
        if ib1[i] + ib2[i] == 0 :
            lst.append(0)
        elif ib1[i] + ib2[i] == 1 :
            lst.append(1)
        elif ib1[i] + ib2[i] == 2 :
            lst.append(0)
            if i != 0:
                ib1[i-1] += 1
            else:
                lst.append(1)
        elif ib1[i] + ib2[i] == 3:
            lst.append(1)
            if i != 0:
                ib1[i-1] += 1
            else:
                lst.append(1)
 
    return ''.join(map(str, list(reversed(lst))))