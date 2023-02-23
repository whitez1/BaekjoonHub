def solution(order):
    list_order = list(map(int, list(str(order)))) 
    return list_order.count(3) + list_order.count(6) + list_order.count(9) 