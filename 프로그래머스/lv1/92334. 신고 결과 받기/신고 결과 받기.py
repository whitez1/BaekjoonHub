def solution(id_list, report, k):
    answer = [0]*len(id_list)
    lst = [[] for _ in range(len(id_list))]
    report_lst = [0]*len(id_list)
    stop_id = []    
    for i in report:    # 신고 당한 사람 list 작성
        report_reported = i.split()
        r = id_list.index(report_reported[0])
        if report_reported[1] not in lst[r]:
            lst[r].append(report_reported[1])
            report_lst[id_list.index(report_reported[1])] += 1
            
    for idx, j in enumerate(report_lst): # 정지된 사람 list
        if j >= k:
            stop_id.append(id_list[idx])
            
    for r in range(len(id_list)):
        for c in range(len(lst[r])):
            if lst[r][c] in stop_id:
                answer[r] += 1
    
    return answer