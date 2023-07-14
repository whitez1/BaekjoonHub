def solution(line):
    pos, answer = [], []
    n = len(line)
    
    x_min = y_min = int(1e15)
    x_max = y_max = -int(1e15)
    
    for i in range(n):
        a, b, e = line[i]
        for j in range(i+1, n):
            c, d, f = line[j]
            if a*d == b*c: continue
            x = (b*f-e*d)/(a*d-b*c)
            y = (e*c-a*f)/(a*d-b*c)
            if x == int(x) and y == int(y):
                x = int(x)
                y = int(y)
                pos.append([x, y])
                if x < x_min: x_min = x
                if x > x_max: x_max = x
                if y < y_min: y_min = y
                if y > y_max: y_max = y
            
    x_len = x_max - x_min + 1
    y_len = y_max - y_min + 1
    coord = [['.']*x_len for _ in range(y_len)]
    
    for x, y in pos:
        x = x + abs(x_min) if x_min < 0 else x - x_min
        y = y + abs(y_min) if y_min < 0 else y - y_min
        coord[y][x] = '*'
    
    for result in coord: answer.append(''.join(result))
       
    return answer[::-1]