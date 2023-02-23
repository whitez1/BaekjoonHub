def solution(cipher, code):
    answer = ''
    cipher = list(cipher)
    for i in range(code, len(cipher)+1, code):
        answer += cipher[i-1] 
    return answer