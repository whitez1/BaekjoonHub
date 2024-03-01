s = input()
a = set()
for i in range(0, len(s)):
    for j in range(i+1, len(s)+1):
        a.add(s[i:j])
print(len(a))