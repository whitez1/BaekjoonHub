T = 10
for test_case in range(1, T + 1):
    cnt = int(input())
    boxes = list(map(int, input().split()))

    i = 0
    while True:
        highest = max(boxes)
        lowest = min(boxes)

        highest_index = boxes.index(highest)
        lowest_index = boxes.index(lowest)

        if i == cnt:
            result = boxes[highest_index] - boxes[lowest_index]
            print(f"#{test_case} {result}")
            break

        boxes[highest_index] -= 1
        boxes[lowest_index] += 1

        i += 1