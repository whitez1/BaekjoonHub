def solution(polynomial):
    answer = ''
    coefficient = 0
    constant = 0
    poly_list = polynomial.split(' + ')
    for p in poly_list:
        if 'x' in p:
            s = p[:-1]
            if s == '': s='1'
            coefficient += int(s)
        else:
            constant += int(p)
    if coefficient>0 and constant > 0:
        return 'x + '+str(constant) if coefficient == 1 else str(coefficient)+'x + '+str(constant)
    elif coefficient==0:
        return str(constant)
    else:
        return 'x' if coefficient == 1 else str(coefficient)+'x'
    
    return s