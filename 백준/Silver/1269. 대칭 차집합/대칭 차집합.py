n, m = map(int, input().split())
a = set(map(int, input().split()))
b = set(map(int, input().split()))
answer = (a-b) | (b-a)
print(len(answer))