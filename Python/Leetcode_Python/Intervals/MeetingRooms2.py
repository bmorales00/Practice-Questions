# Time Complexity: O(n log n) || Space Complexity: O(n)
from typing import List
from Intervals.IntervalObject import Interval


def minMeetingRooms(intervals: List[Interval]) -> int:
    if len(intervals) == 0:
        return 0
    if not intervals or len(intervals) == 1:
        return 1

    intervals.sort(key=lambda x: x.start)

    high = 0
    room = 0
    for interval in intervals:
        high = max(high, interval.end)

    rooms = [0] * (high + 1)

    for interval in intervals:
        rooms[interval.start] += 1
        rooms[interval.end] -= 1
    low = 1
    print(rooms)
    for i in range(high + 1):
        if rooms[i] != 0:
            room += rooms[i]
            low = max(low, room)
    return low
