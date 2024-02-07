sum_angle = 0
angles = set()
isEquilateral = True
for _ in range(3):
    angle = int(input())
    sum_angle += angle
    angles.add(angle)
    if angle != 60:
        isEquilateral = False

if sum_angle == 180:
    if isEquilateral:
        print("Equilateral")
    elif len(angles) == 2:
        print("Isosceles")
    else:
        print("Scalene")
else:
    print("Error")
