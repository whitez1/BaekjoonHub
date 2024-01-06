student = set()
compare = {i for i in range(1, 31)}
for _ in range(28):
    num = int(input())
    student.add(num)

mod = sorted(list(compare - student))

print(mod[0])
print(mod[1])