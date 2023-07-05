def solution(id_pw, db):
    for info in db:
        if id_pw[0] == info[0] and id_pw[1] == info[1]:
            return "login"
        elif id_pw[0] == info[0]:
            return "wrong pw"
    return "fail"
