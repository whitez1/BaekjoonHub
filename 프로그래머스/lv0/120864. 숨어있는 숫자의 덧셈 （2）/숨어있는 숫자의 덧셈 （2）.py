import re
def solution(my_string):
    my_string = re.sub('[^0-9]',' ', my_string)
    my_string = list(map(int, my_string.split()))
    return sum(my_string)    