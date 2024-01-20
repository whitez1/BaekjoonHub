grade_table = {'A+': 4.5, 'A0': 4.0, 'B+': 3.5, 'B0': 3.0, 'C+': 2.5, 'C0': 2.0, 'D+': 1.5, 'D0': 1.0, 'F': 0.0}
gr_sum = 0
r_sum = 0
for _ in range(20):
    lst = input().split()
    rate, grade = lst[1], lst[2]
    if grade == 'P':
        continue
    rate, grade = float(rate), grade_table[grade]
    gr_sum += grade * rate
    r_sum += rate
print(gr_sum/r_sum)
    