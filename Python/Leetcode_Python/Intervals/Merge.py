from typing import List


def merge(intervals: List[List[int]]) -> List[List[int]]:
    if len(intervals) == 1:
        return intervals

    if not intervals:
        return []

    intervals.sort(key=lambda x: x[0])

    res = []
    res.append(intervals[0])

    for i in range(1, len(intervals)):
        if res[-1][1] < intervals[i][0]:
            res.append(intervals[i])
        else:
            res[-1][1] = max(res[-1][1], intervals[i][1])

    return res


# def overlaps(prev, next) -> bool:
#     cond1 = next[0] >= prev[0] and next[0] <= prev[1]
#     cond2 = next[1] >= prev[0] and next[0] <= prev[0]
#     cond3 = next[0] >= prev[0] and next[1] <= prev[0]
#
#     return cond1 or cond2 or cond3
