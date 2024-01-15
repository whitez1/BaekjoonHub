word = input()
word = word.upper()
word_count = dict()
maxval = 0
maxWord = -1
for i in word:
    word_count[i] = word_count.get(i, 0) + 1

for j in set(word):
    if word_count[j] > maxval:
        maxval = word_count[j]
        maxWord = j

if list(word_count.values()).count(maxval) > 1:
    print('?')
else: print(maxWord)