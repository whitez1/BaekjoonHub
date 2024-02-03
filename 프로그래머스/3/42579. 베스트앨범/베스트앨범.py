from collections import defaultdict
def solution(genres, plays):
    answer = []
    genpl = defaultdict(list)
    max_genre = dict()

    for i in range(len(genres)):
        genpl[genres[i]].append([i, plays[i]])

    for j in genpl:
        genpl[j] = sorted(genpl[j], key = lambda x:x[1], reverse = True)
        max_genre[j] = sum([m[1] for m in genpl[j]])
    max_gen = sorted(max_genre.items(), key = lambda x:x[1], reverse = True)
    for k in max_gen:
        maxgen = k[0]
        if len(genpl[maxgen]) == 1:
            answer.append(genpl[maxgen][0][0])
        else:
            answer.append(genpl[maxgen][0][0])
            answer.append(genpl[maxgen][1][0])
        
    return answer