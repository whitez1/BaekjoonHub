def solution(array):
    return sum([i.count('7') for i in list(map(str, array))])