def solution(bandage, health, attacks):
    answer = health
    max_health = health
    cnt_success = 0
    
    time = sorted(attacks, reverse = True)[0][0]
    attacks = dict(attacks)
    for i in range(1, time+1):
        if attacks.get(i, 0) != 0:
            answer -= attacks[i]
            if answer <= 0:
                answer = -1
                break
            cnt_success = 0
        else:
            answer += bandage[1]
            cnt_success += 1
            if cnt_success == bandage[0]:
                answer += bandage[2]
                cnt_success = 0
            if answer > max_health:
                answer = max_health        
    return answer