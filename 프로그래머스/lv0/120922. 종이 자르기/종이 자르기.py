def solution(M, N):
    answer = 0
    paper_num = 1
    if M > 1:
        answer += M-1
        paper_num = M
    if N > 1:
        answer += paper_num * (N-1)
    return answer