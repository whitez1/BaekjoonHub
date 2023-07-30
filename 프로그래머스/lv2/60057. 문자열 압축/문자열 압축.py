from collections import defaultdict
def solution(s):
    answer = len(s)
    for i in range(1, len(s)//2+1):
        comp_len = 0
        comp = ''
        cnt = 1
        for j in range(0, len(s)+1, i):
            temp = s[j:j+i]
            if comp == temp: cnt += 1
            else:
                comp_len += len(temp)
                if cnt > 1: comp_len += len(str(cnt))
                cnt = 1
                comp = temp
        answer = min(answer, comp_len)
    return answer        
