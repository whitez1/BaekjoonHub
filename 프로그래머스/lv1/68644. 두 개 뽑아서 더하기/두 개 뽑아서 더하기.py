from itertools import combinations
def solution(numbers):
    answer = set()
    for i, j in combinations(numbers, 2):
        answer.add(i+j)
    return sorted(answer)