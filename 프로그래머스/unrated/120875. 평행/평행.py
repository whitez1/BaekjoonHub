import itertools

def solution(dots):
    answer = 0
    tuple_dots = [tuple(t) for t in dots]
    comdot = list(itertools.combinations(tuple_dots, 2))

    for d in comdot:
        w1 = [d[0][0] - d[1][0], d[0][1] - d[1][1]]
        d2 = list(set(tuple_dots)-set(d))
        w2 = [d2[0][0] - d2[1][0], d2[0][1] - d2[1][1]]
        if w1[0]/w2[0] == w1[1]/w2[1]:
            return 1
    return 0