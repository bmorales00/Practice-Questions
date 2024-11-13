from typing import List


def insert(intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
    if not intervals:
        return []
    if len(intervals) == 0:
        intervals.append(newInterval)
        return intervals

    res = []
    left = -1
    print(len(intervals))
    for i in range(len(intervals)):
        interval = intervals[i]
        print(overlaps(interval, newInterval))

        if overlaps(interval, newInterval):
            newInterval[0] = min(newInterval[0], interval[0])
            newInterval[1] = max(newInterval[1], interval[1])
        else:
            if newInterval[0] < interval[0]:
                res.append(newInterval)
                left = i
                break
            else:
                res.append(interval)
    print(newInterval)
    if left == -1:
        res.append(newInterval)
    else:
        for i in range(left, len(intervals)):
            res.append(intervals[i])
    return res

    # If overlaps, we fuse
    # if it does not overlap, then we have to choices
    # if the new interval is smaller then we add it and break the loop and then add the rest
    # if the current interval is smaller then we just add the smaller interval and coninue


def overlaps(old: List[int], new: List[int]) -> bool:
    cond1 = new[1] >= old[1] and new[0] <= old[1]
    cond2 = new[0] <= old[0] and new[1] >= old[0]
    cond3 = new[0] >=old[0] and new[1] <= old[1]

    return cond1 or cond2 or cond3
