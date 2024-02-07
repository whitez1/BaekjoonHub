while True:
    tr = list(map(int, input().split()))
    if sum(tr) == 0:
        break
    if max(tr) < sum(tr)-max(tr):
        if tr[0]==tr[1]==tr[2]:
            print("Equilateral")
        elif tr[0]!=tr[1] and tr[1]!=tr[2] and tr[0]!=tr[2]:
            print("Scalene")
        else:
            print("Isosceles")
    else:
        print("Invalid")