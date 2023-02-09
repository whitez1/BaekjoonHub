def solution(babbling):
    answer = 0
    possible = ['aya', 'ye', 'woo', 'ma']

    for bab in babbling:
        for pos in possible: 
            bab = bab.replace(pos, ' ', 1)
        if len(bab.strip()) == 0:
            answer += 1
    return answer