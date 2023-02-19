def solution(sides):
    answer = 0
    maxs = max(sides)
    sides.pop(sides.index(maxs))
    return 1 if maxs < sum(sides) else 2