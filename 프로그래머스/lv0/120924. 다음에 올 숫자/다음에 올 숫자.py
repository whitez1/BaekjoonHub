def solution(common):
    answer = 0
    com_diff = common[1] - common[0]
    if common[0] != 0:
        com_ratio = common[1] / common[0]
        
    if common[2] == (common[1] + com_diff):
        answer = common[len(common)-1] + com_diff
    else:
        answer = common[len(common)-1] * com_ratio
    return answer  