def solution(arr1, arr2):
    rn1, rn2 = len(arr1), len(arr2)
    cn1, cn2 = len(arr1[0]), len(arr2[0]) 
    answer = [[0]*cn2 for _ in range(rn1)]
    
    for i in range(rn1):
        for k in range(cn2):
            sum = 0
            for j in range(cn1):
                sum += arr1[i][j]*arr2[j][k]
            answer[i][k] = sum
            
    return answer