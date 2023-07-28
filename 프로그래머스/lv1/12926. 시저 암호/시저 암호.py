def solution(s, n):
    answer = []
    for c in s:
        i = ord(c)
        if 65<=i<=90:
            i = 65+(i+n-65)%26
        elif 97<=i<=122:
            i = 97+(i+n-97)%26
        answer.append(chr(i))    
            
    return ''.join(answer)