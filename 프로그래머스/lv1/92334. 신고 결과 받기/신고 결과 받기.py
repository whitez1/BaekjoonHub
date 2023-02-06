def solution(id_list, report, k):
    answer = []
    matrix = [[0]*len(id_list) for _ in range(len(id_list))]
    for i in report:
        a, b = i.split()
        r=id_list.index(a)
        c=id_list.index(b)
        matrix[r][c]=1
    report_count=[]  
    for r in range(len(id_list)):
        sum=0
        for c in range(len(id_list)):
            sum+=matrix[c][r]
        report_count.append(sum)

    stop_id_idx=[]
    for j in range(len(id_list)):
        if report_count[j] >= k:
            stop_id_idx.append(j)
            
    for r in range(len(id_list)):
        sum=0
        for c in stop_id_idx:
            sum+=matrix[r][c]
        answer.append(sum)        
    return answer