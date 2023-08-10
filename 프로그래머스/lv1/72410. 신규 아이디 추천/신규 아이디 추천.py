def solution(new_id):
    
    #step1
    new_id = new_id.lower()
    
    #step 2
    special = "~!@#$%^&*()=+[{]}:?,<>/"
    for s in special:
        if s in new_id: 
            new_id = new_id.replace(s, '')
            
    #step3
    while '..' in new_id:
        new_id = new_id.replace('..', '.')
    
    #step4
    new_id = new_id.strip('.')

    #step5
    if new_id == "": new_id = "a"
    
    #step6
    if len(new_id) >= 16: new_id = new_id[:15]
    new_id = new_id.strip('.')
    
    #step7
    while len(new_id)<3: 
        new_id += new_id[-1]

    return new_id