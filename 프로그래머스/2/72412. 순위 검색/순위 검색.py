from collections import defaultdict
from itertools import combinations
from bisect import bisect_left

def solution(info, query):
    answer = []
    people = defaultdict(list)
    
    for i in info:
        person = i.split()
        score = int(person.pop())
        people[''.join(person)].append(score)
        
        for j in range(4):
            case = list(combinations(person, j))
            for c in case:
                people[''.join(c)].append(score)
    
    for i in people: people[i].sort()
    
    for q in query:
        key = q.split()
        score = int(key.pop())
        key = ''.join(key)
        key = key.replace('and', '').replace('-', '')
        answer.append(len(people[key]) - bisect_left(people[key],score))
        
    return answer