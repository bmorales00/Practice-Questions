from typing import List


def findContentChildren(g: List[int], s: List[int]) -> int:
    if not g or not s:
        return 0

    if len(s) == 0:
        return 0

    g.sort()
    s.sort()

    i = 0
    j = 0
    count = 0
    while i < len(g) and j < len(s):
        if g[i] > s[j]:
            j += 1
            continue
        i += 1
        j += 1
        count += 1

    return count
