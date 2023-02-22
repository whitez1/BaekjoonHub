import re
def solution(my_string):
    answer = []
    integer = [0,1,2,3,4,5,6,7,8,9]
    integer = list(map(str,integer))
    for i in my_string:
        if i in integer:
            answer.append(int(i))
    answer.sort()
    return answer