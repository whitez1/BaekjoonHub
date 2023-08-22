def solution(answers):
    answer = []
    person1 = [1,2,3,4,5]
    person2 = [2,1,2,3,2,4,2,5]
    person3 = [3,3,1,1,2,2,4,4,5,5]
    
    ans1 = []
    ans2 = []
    ans3 = []
    
    sum1, sum2, sum3 = 0, 0, 0
    
    for i in range(len(answers)):
        ans1.append(person1[i%len(person1)])
        ans2.append(person2[i%len(person2)])
        ans3.append(person3[i%len(person3)])
    
    for idx, n in enumerate(answers):
        if n == ans1[idx]:
            sum1 += 1
        if n == ans2[idx]:
            sum2 += 1
        if n == ans3[idx]:
            sum3 += 1
    maxval = max(sum1, sum2, sum3)
    if sum1 == maxval: answer.append(1)
    if sum2 == maxval: answer.append(2)
    if sum3 == maxval: answer.append(3)
    return answer