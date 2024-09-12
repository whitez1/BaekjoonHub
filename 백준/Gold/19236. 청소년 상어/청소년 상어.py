def main():
    graph = [[] for _ in range(4)]

    dx = [-1, -1, 0, 1, 1, 1, 0, -1]
    dy = [0, -1, -1, -1, 0, 1, 1, 1]

    for i in range(4):
        data = list(map(int, input().split()))
        fish = []
        for j in range(4):
            fish = [data[2*j], data[2*j+1]]
            graph[i].append(fish)
    print(dfs(dx, dy, graph))


def dfs(dx, dy, graph):
    stack = []
    result = []
    visited = [0] * 16
    stack.append([0, 0, 0, 0, graph, visited])

    while stack:
        sx, sy, score, sd, g, visited = stack.pop()
        score += g[sx][sy][0]
        visited[g[sx][sy][0]-1] = 1
        sd = g[sx][sy][1]

        # 물고기 이동
        cnt = 1
        while cnt <=16:
            isnext = False
            if visited[cnt-1] == 1:
                cnt += 1
                continue
            for i in range(4):
                for j in range(4):
                    if g[i][j][0] == cnt:
                        d = g[i][j][1] - 1
                        while True:
                            nx = i + dx[d]
                            ny = j + dy[d]
                            if 0<=nx<=3 and 0<=ny<=3 and (nx != sx or ny != sy):
                                break
                            else:
                                d = (d+1)%8
                        temp = [cnt, d+1]
                        g[i][j] = g[nx][ny]
                        g[nx][ny] = temp
                        isnext = True
                        break
                if isnext:
                    break
            cnt += 1

        # 상어 이동
        scnt = 0
        sd -= 1
        snx, sny = sx, sy
        while True:
            snx += dx[sd]
            sny += dy[sd]
            if snx<0 or snx>3 or sny<0 or sny>3:
                break
            if visited[g[snx][sny][0]-1] == 1:
                continue
            stack.append([snx, sny, score, sd+1, [arr[:] for arr in g], visited[:]])
            scnt += 1
        if scnt == 0:
            result.append(score)
    return max(result)
main()