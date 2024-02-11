a, b, c, d, e, f = map(int, input().split())
x = (c*e-b*f)//(a*e-d*b)
y = (a*f-c*d)//(a*e-d*b)
print(x, y)