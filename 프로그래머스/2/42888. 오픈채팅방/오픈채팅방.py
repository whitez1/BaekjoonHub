def solution(record):
    answer = []
    name = {}
    temp = []
    for r in  record:
        lst = r.split()
        if len(lst) == 2:
            temp.append(lst[1]+'!'+"님이 나갔습니다.")
        else:
            name[lst[1]] = lst[2]
            if lst[0] == "Enter":
                temp.append(lst[1]+'!'+"님이 들어왔습니다.")
    for t in temp:
        lst2 = t.split('!')
        key = lst2[0]
        lst2[0] = name[key]
        answer.append(''.join(lst2))
            
    return answer