def solution(babbling):
    answer = 0
    possible = ['aya', 'ye', 'woo', 'ma']
    cnt = [0]*4
    for idx, bab in enumerate(babbling):
        count = 0 
        for pos in possible: 
            if pos in bab:
                count += 1
                babbling[idx] = babbling[idx].replace(pos, '1')
        if babbling[idx] == '1'*count:
            answer += 1
            
    return answer