while True:
    s = input()
    stack = []
    is_vps = True

    if s == '.':
        break
    for i in s:
        if i == '(' or i == '[':
            stack.append(i)
        elif (i == ')' or i == ']') and not stack:
            is_vps = False
            break
        elif i == ')':
            a = stack.pop()
            if a != '(':
                is_vps = False
                break
        elif i == ']':
            b = stack.pop()
            if b != '[':
                is_vps = False
                break
    if not stack and is_vps:
        print('yes')
    else:
        print('no')
