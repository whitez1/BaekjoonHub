def solution(numbers):
    num = []
    for _ in range(2):
        num.append(max(numbers))
        numbers.pop(numbers.index(max(numbers)))
    return num[0] * num[1] 