cnt = 0
def solution(board):
    global cnt
    row = [-1, -1, -1, 0, 0, 1, 1, 1]
    col = [-1, 0, 1, -1, 1, -1, 0, 1]
    n = len(board)
    for i in range(n):
        for j in range(n):
            if board[i][j] == 1:
                dfs(i, j, row, col, board)
    return n*n - cnt

def dfs(r, c, row, col, board):
    global cnt
    cnt += 1
    board[r][c] = 2
    for i in range(8):
        rr = r+row[i]
        cc = c+col[i]
        if 0 <= rr < len(board) and 0 <= cc < len(board):
            if board[rr][cc] == 0:
                cnt += 1
                board[rr][cc] = 2

            elif board[rr][cc] == 1:
                dfs(rr, cc, row, col, board)