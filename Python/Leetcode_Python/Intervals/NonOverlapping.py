# Time Complexity: O(n log n ) || Space Complexity: O(1)
from typing import List


def eraseOverlapIntervals(intervals: List[List[int]]) -> int:
    if len(intervals) == 1:
        return 0

    removed = 0
    intervals.sort(key=lambda x: x[0])

    interval = intervals[0]

    for i in range(1, len(intervals)):
        current = intervals[i]
        if interval[-1] > current[0]:
            interval[-1] = min(interval[-1], current[-1])
            removed += 1
        else:
            interval = current

    return removed
