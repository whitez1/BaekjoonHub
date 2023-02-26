import collections
def solution(array, n):
    if n not in array:
        array.append(n)
        array.sort()
        i = array.index(n)
        if i == len(array)-1:
            return array[-2]
        elif i == 0:
            return array[1]
        elif n-array[i-1] <= array[i+1]-n:
            return array[i-1]
        else:
            return array[i+1]
    else:
        return n
    