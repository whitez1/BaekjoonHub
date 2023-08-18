import re
def solution(phone_number):
#   l = len(phone_number)-4
#   return '*'*l+phone_number[l:]
    return re.sub("\d(?=\d{4})", "*", phone_number)