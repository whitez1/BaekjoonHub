def dfs(n):
    global answer
    if n == cnt:
        answer = max(answer, int("".join(nums)))
        return
    for i in range(l-1):
        for j in range(i+1, l):
            nums[i], nums[j] = nums[j], nums[i]

            chk = int("".join(nums))
            if (n, chk) not in v:
                v.append((n, chk))
                dfs(n+1)

            nums[i], nums[j] = nums[j], nums[i]

T = int(input())

for test_case in range(1, T + 1):
    nums, cnt = input().split()
    nums = list(nums)
    cnt = int(cnt)

    answer = 0
    l = len(nums)
    v = []
    dfs(0)
    print(f"#{test_case} {answer}")