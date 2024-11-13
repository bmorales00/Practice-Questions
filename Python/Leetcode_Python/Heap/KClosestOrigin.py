# Time Complexity: O(nlogn) || Space Complexity:O(n)
from typing import List
import heapq


def kClosest(points: List[List[int]], k: int) -> List[List[int]]:
    if not points:
        return []

    heap = []
    pointMapper = dict()
    res = []

    for point in points:
        x = point[0] ** 2
        y = point[1] ** 2
        total = x + y
        if total not in pointMapper:
            pointMapper[total] = list()
        pointMapper[total].append(point)
        heapq.heappush(heap, total)

    while heap and len(res) < k:
        small = heapq.heappop(heap)
        point = pointMapper[small].pop()
        res.append(point)

    return res
