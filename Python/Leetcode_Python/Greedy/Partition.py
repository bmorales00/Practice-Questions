# Time Complexity: O(n) || Space Complexity: O(n)
from typing import List


def partitionLabels(s: str) -> List[int]:
    if not s:
        return []

    last = dict()

    for i in range(len(s)):
        last[s[i]] = i

    start = 1
    end = last[s[0]]
    res = []
    for i in range(len(s)):
        if last[s[i]] > end:
            end = last[s[i]]
        if i == end:
            res.append(start)
            start = 1
            continue
        start += 1
    return res
