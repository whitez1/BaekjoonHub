def solution(numbers, hand):
    answer = ''
    left = '*'
    right = '#'
    
    if hand == "left": hand = 'L'
    else: hand = 'R'
    left_pad = [1, 4, 7, '*']
    mid_pad = [2, 5, 8, 0]
    right_pad = [3, 6, 9, '#']
    keypad = {1:'L', 4:'L', 7:'L', 3:'R', 6:'R', 9:'R'} 
    
    for number in numbers:
        if number in keypad:
            answer += keypad[number]
            if keypad[number] == 'L':
                left = number
            else:
                right = number
        else:
            m = mid_pad.index(number)
            if left == number:
                answer += 'L'
                continue
            elif right == number:
                answer += 'R'
                continue
            if left in left_pad:
                l = left_pad.index(left)
            elif left in mid_pad:
                l = mid_pad.index(left)             
                if m<l: l -= 1
                else: l += 1
            if right in right_pad:
                r = right_pad.index(right)
            elif right in mid_pad:
                r = mid_pad.index(right)
                if m<r: r -= 1
                else: r += 1
            if abs(m-l)==abs(m-r):
                answer += hand
                if hand == 'L':
                    left = number
                else: right = number
            elif abs(m-l)<abs(m-r):
                answer += 'L'
                left = number
            else:
                answer += 'R'
                right = number
    return answer