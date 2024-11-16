import heapq

T = 10
for test_case in range(1, T + 1):
    cnt = int(input())
    boxes = list(map(int, input().split()))
    minus_boxes = [-box for box in boxes]
    heapq.heapify(boxes)
    heapq.heapify(minus_boxes)

    i = 0
    while True:
        highest = -heapq.heappop(minus_boxes)
        lowest = heapq.heappop(boxes)

        if i == cnt:
            result = highest - lowest
            print(f"#{test_case} {result}")
            break

        highest = highest - 1
        lowest = lowest + 1

        heapq.heappush(minus_boxes, -highest)
        heapq.heappush(minus_boxes, -lowest)

        heapq.heappush(boxes, highest)
        heapq.heappush(boxes, lowest)

        i += 1