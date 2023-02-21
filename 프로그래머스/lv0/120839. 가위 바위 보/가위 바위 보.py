def solution(rsp):
    gawibawibo = [2, 0, 5]
    lst = list(map(int, list(rsp)))
    return ''.join([str(gawibawibo[(gawibawibo.index(i)+1)%3]) for i in lst])