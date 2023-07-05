from collections import defaultdict
def solution(score):
    answer = [0]*len(score)
    avgDict = defaultdict(list)
    for idx, s in enumerate(score):
        avg = (s[0] + s[1]) / 2
        avgDict[avg].append(idx) 
    avgList = list(reversed(sorted(avgDict)))
    print(avgList)
    
    rank = 1
    for a in avgList:
        for i in avgDict[a]:
            answer[i] = rank
        rank += len(avgDict[a])
    return answer