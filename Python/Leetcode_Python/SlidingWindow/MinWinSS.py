# Time Complexity: O(n) || Space Complexity: O(n)
from typing import Deque


def minWindow(s: str, t: str) -> str:
    if len(t) > len(s):
        return ""

    h1, h2, h3 = dict(), dict(), dict()

    res = ""
    mWin = 100001

    for char in t:
        if char not in h1:
            h1[char] = 0
            h2[char] = 0
            h3[char] = 0
        h1[char] += 1
        h3[char] += 1

    l = 0

    size = len(s)

    while l < size and s[l] not in h1:
        l += 1

    r = l

    while r < size and h3:
        char = s[r]
        if char in h3:
            if h3[char]-1 <= 0:
                h3.pop(char)
            else:
                h3[char] -= 1
        if char in h2:
            h2[char] += 1
        r += 1
    if h3:
        return ""

    r -= 1 
    while r < size:
        lch = s[l]
        if (r - l) + 1 < mWin:
            mWin = (r - l) + 1
            res = s[l : r + 1]

        if h2[lch] - 1 < h1[lch]:
            while l < size and s[l] not in h1:
                l += 1
            r += 1
            while r < size and s[r] != lch:
                if s[r] in h2:
                    h2[s[r]] += 1
                r += 1
        else:
            h2[lch] -= 1
            l += 1
            while l < size and s[l] not in h1:
                l += 1
    return res
