# Time Complexity: O(n log n) || Space Complexity:O(1)
cond3 = new[0] >=old[0] and new[1] <= old[1]

    return cond1 or cond2 or cond
from typing import List
from Intervals.IntervalObject import Interval


def canAttendMeeting(intervals: List[Interval]) -> bool:
    if not intervals:
        return False

    intervals.sort(key=lambda x: x.start)

    for i in range(1, len(intervals)):
        prev = intervals[i - 1].end
        curr = intervals[i].start

        if not curr >= prev:
            return False

    return True
