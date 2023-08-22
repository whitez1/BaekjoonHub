import sys
sys.setrecursionlimit(2000)

def solution(k, room_number):
    rooms = dict()
    answer = []
    for num in room_number:
        answer.append(find_emptyroom(num, rooms))
    return answer

def find_emptyroom(chk, rooms):
    if chk not in rooms:
        rooms[chk] = chk + 1
        return chk
    empty = find_emptyroom(rooms[chk], rooms)
    rooms[chk] = empty + 1
    return empty