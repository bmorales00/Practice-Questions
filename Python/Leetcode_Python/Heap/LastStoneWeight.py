from typing import List
import heapq


def lastStoneWeight(stones: List[int]) -> int:
    if not stones:
        return 0
    if len(stones) == 1:
        return stones[0]

    max_pq = []

    for stone in stones:
        heapq.heappush(max_pq, stone * -1)

    while len(max_pq) > 1:
        x = heapq.heappop(max_pq) * -1
        y = heapq.heappop(max_pq) * -1

        if x != y:
            if x > y:
                heapq.heappush(max_pq, (x - y) * -1)
            else:
                heapq.heappush(max_pq, (y - x) * -1)

    return 0 if len(max_pq) == 0 else max_pq[0]
