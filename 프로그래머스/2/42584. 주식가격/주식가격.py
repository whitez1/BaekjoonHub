def solution(prices):
    answer = []
    for i, j in enumerate(prices):
        for k in range(i+1, len(prices)):
            if prices[k]-j<0:
                answer.append(k-i)
                break
        if len(answer) != i+1:
            answer.append(len(prices)-1-i)
    return answer