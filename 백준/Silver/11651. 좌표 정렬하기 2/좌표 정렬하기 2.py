n = int(input())
points = []
for i in range(n):
    point = tuple(map(int, input().split()))
    points.append(point)
points.sort(key=lambda x: (x[1], x[0]))
for j in points:
    print(*j)