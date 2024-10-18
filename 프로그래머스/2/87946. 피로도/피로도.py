import itertools
def solution(k, dungeons):
    answer = 0
    for ds in itertools.permutations(dungeons, len(dungeons)):
        a = 0
        nk = k
        for mf, sf in ds: 
            if nk >= mf:
                nk -= sf
                a += 1
        answer = max(answer, a)
    return answer