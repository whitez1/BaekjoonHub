n = int(input())
cnt = 0
for i in range(n):
    word = input()
    word_set = set(word)
    prev = word[0]
    for l, j in enumerate(word):
        if j != prev:
            if prev in word_set:
                word_set.remove(prev)
            else:
                cnt -= 1
                break
        if l == len(word)-1:
            if j not in word_set:
                cnt -= 1
        prev = j

    cnt += 1
print(cnt)