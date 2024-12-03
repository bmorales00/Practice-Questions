from typing import List


def reverseString(s: List[str]) -> None:
    if not s or len(s) == 0:
        return

    p1 = 0
    p2 = len(s) - 1

    while p1 < p2:
        temp = s[p1]
        s[p1] = s[p2]
        s[p2] = temp
        p1 += 1
        p2 -= 1
