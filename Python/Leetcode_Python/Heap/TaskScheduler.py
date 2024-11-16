from typing import List
import heapq


def leastInterval(tasks: List[str], n: int) -> int:
    if not tasks:
        return -1

    time = 0
    maxHeap = []
    queue = []
    letters = [0] * 26

    for task in tasks:
        letters[ord(task) - 65] += 1

    for letter in letters:
        if letter != 0:
            heapq.heappush(maxHeap, -letter)

    while True:
        if not maxHeap and not queue:
            break
        if len(queue) != 0 and queue[0][1] <= time:
            temp = queue.pop(0)
            heapq.heappush(maxHeap, temp[0])
        if len(maxHeap) != 0:
            val = heapq.heappop(maxHeap) + 1
            if val != 0:
                queue.append([val, time + n + 1])
        time += 1

    return time
