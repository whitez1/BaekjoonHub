def solution(rows, columns, queries):
    answer = []
    
    # rows x columns 배열 생성  
    list_2d = [[j for j in range(1+columns*i, (i+1)*columns+1)] for i in range(rows)]
    
    # queries 테두리 배열 회전 후 가장 작은 숫자 구하기
    for q in queries:
        min = int(1e15)
        q[0] -= 1
        q[1] -= 1
        q[2] -= 1
        q[3] -= 1
        for row1 in range(q[0], q[2]):
            col = q[1]
            if list_2d[row1+1][col] < min: min = list_2d[row1+1][col]
            temp = list_2d[row1][col]
            if temp < min: min = temp
            list_2d[row1][col] = list_2d[row1+1][col]
            list_2d[row1+1][col] = temp
            
        for col1 in range(q[1], q[3]):
            row = q[2]
            if list_2d[row][col1+1] < min: min = list_2d[row][col1+1]
            temp = list_2d[row][col1]
            list_2d[row][col1] = list_2d[row][col1+1]
            list_2d[row][col1+1] = temp
           
        for row2 in range(q[2], q[0], -1):
            col = q[3]
            if list_2d[row2-1][col] < min: min = list_2d[row2-1][col]
            temp = list_2d[row2][col]
            list_2d[row2][col] = list_2d[row2-1][col]
            list_2d[row2-1][col] = temp
          
        for col2 in range(q[3], q[1]+1, -1):
            row = q[0]
            if list_2d[row][col2-1] < min: min = list_2d[row][col2-1]
            temp = list_2d[row][col2]
            list_2d[row][col2] = list_2d[row][col2-1]
            list_2d[row][col2-1] = temp   
           
        answer.append(min)
    return answer

