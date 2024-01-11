from collections import defaultdict
def solution(participant, completion):
    part_dict = defaultdict(int)
    for p in participant:
        part_dict[p] += 1
    for c in completion:
        part_dict[c] -= 1
        if part_dict[c] == 0:
            part_dict.pop(c)
    for i in part_dict:
        return i