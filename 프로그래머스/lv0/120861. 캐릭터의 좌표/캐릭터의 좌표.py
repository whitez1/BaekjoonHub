def solution(keyinput, board):
    answer = [0,0]
    for k in keyinput:
        temp1 = answer[1]
        temp0 = answer[0]
        if k == "up": 
            answer[1] += 1
        elif k == "down":
            answer[1] -= 1
        elif k == "left":
            answer[0] -= 1
        else:
            answer[0] += 1
        if board[1]//2*(-1)>answer[1] or answer[1]>board[1]//2:
            answer[1] = temp1
        elif board[0]//2*(-1)>answer[0] or answer[0]>board[0]//2:
            answer[0] = temp0

    return answer