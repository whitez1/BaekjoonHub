import sys
sys.setrecursionlimit(10000)
def preorder(y, x, answer):
    node = y[0]
    idx = x.index(node)
    left, right = [], []

    for i in range(1, len(y)):
        if node[0] > y[i][0]: left.append(y[i])
        else: right.append(y[i])
        
    answer.append(node[2])
    if len(left) > 0: preorder(left, x[:idx], answer)
    if len(right) > 0: preorder(right, x[idx + 1:], answer)
    
def postorder(y, x, answer):
    node = y[0]
    idx = x.index(node)
    left, right = [], []
    
    for i in range(1, len(y)):
        if node[0] > y[i][0]: left.append(y[i])
        else: right.append(y[i])
        
    
    if len(left) > 0: postorder(left, x[:idx], answer)
    if len(right) > 0: postorder(right, x[idx + 1:], answer)
    answer.append(node[2])
    
def solution(nodeinfo):
    nodeinfo = [[*info, idx+1] for idx, info in enumerate(nodeinfo)]
    y = sorted(nodeinfo, key = lambda x: -x[1])
    x = sorted(nodeinfo)
    
    preorderList = []
    postorderList = []
    
    preorder(y, x, preorderList)
    postorder(y, x, postorderList)
    return [preorderList, postorderList]