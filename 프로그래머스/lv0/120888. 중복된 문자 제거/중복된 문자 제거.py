def solution(my_string):
    answer = ''
    remove_duplicate = set(my_string)
    for s in my_string:
        if s in remove_duplicate:
            answer += s
            remove_duplicate.remove(s)
    return answer