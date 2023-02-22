from collections import deque
def solution(numbers, direction):
    numbers = deque(numbers)
    if direction == "right":
        numbers.rotate()
    else:
        numbers.rotate(-1)
    return list(numbers)