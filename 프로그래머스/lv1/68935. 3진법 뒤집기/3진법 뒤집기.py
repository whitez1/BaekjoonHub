def radixChange(num):
    if num == 0: return '0'
    nums = []
    while num:
        num, digit = divmod(num, 3)
        nums.append(str(digit))
    return ''.join(reversed(nums))

def solution(n):
    return int(radixChange(n)[::-1], 3)