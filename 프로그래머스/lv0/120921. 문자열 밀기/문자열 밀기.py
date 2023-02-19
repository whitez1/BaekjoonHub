def solution(A, B):
    answer = 0
    for i in range(len(A)):
        if A==B:
            return answer
        A = A[len(A)-1:] + A[0:len(A)-1]
        answer += 1
    return -1