import sys
input = sys.stdin.readline

def main():
    N = int(input())
    A = []
    B = [[0]*N for _ in range(N)]
    dx = [0, 1, 0, -1]
    dy = [-1, 0, 1, 0]

    x = N//2
    y = N//2
    B[x][y] = 1

    sand_per = [[(0, 0), 5], [(0, 1), 10], [(0, 3), 10], [(-1, 1), 7], [(-1, 3), 7], [(1, 1), 2], [(3, 3), 2], [(2, 1), 1], [(2, 3), 1]]

    for _ in range(N):
        A.append(list(map(int, input().rstrip().split())))

    result = 0
    di = 0
    cnt = 1

    while cnt <= N*N-1:
        nx = x + dx[di]
        ny = y + dy[di]

        if B[nx][ny] == 1:
            di = (di - 1) % 4
            nx = x + dx[di]
            ny = y + dy[di]

        B[nx][ny] = 1

        nsand = A[nx][ny]
        remain = A[nx][ny]
        for c, per in sand_per:
            if c[0] == -1:
                ib = (di + c[1]) % 4
                sx = nx + dx[ib]
                sy = ny + dy[ib]
            else:
                ia = (di + c[0]) % 4
                ib = (di + c[1]) % 4
                sx = nx + dx[ia] + dx[ib]
                sy = ny + dy[ia] + dy[ib]
            fsand = int(nsand * (per/100))
            if 0 <= sx < N and 0 <= sy < N:
                A[sx][sy] += fsand
            else:
                result += fsand
            remain -= fsand

        sx = nx + dx[di]
        sy = ny + dy[di]
        if 0 <= sx < N and 0 <= sy < N:
            A[sx][sy] += remain
        else:
            result += remain
        A[nx][ny] = 0

        di = (di + 1) % 4
        cnt += 1
        x = nx
        y = ny
    print(result)
main()