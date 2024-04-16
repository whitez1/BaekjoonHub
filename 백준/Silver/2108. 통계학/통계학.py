from statistics import mean, median
import math, sys

input = sys.stdin.readline
n = int(input())
nums = []
nums_cnt = {}
modes = []
for _ in range(n):
    num = int(input())
    nums.append(num)
    nums_cnt[num] = nums_cnt.get(num, 0) + 1

maxcnt = max(nums_cnt.values())
for num, cnt in nums_cnt.items():
    if cnt == maxcnt:
        modes.append(num)
modes.sort()
if len(modes) > 1: mode = modes[1]
else: mode = modes[0]
print(math.floor(mean(nums)+0.5))
print(median(nums))
print(mode)
print(max(nums) - min(nums))
