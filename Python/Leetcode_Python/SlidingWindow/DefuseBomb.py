# Time Complexity: O(n) || Space Complexity: O(n)
from typing import List


def decrypt(code: List[int], k: int) -> List[int]:
    if not code:
        return []
    if k == 0:
        return [0] * len(code)

    i = len(code)
    res = [0] * i
    total = 0
    win = 0
    start = 0
    end = 0
    if k > 0:
        win = k
        start = 1
        end = k
    else:
        win = -(k)
        start = i - win
        end = i - 1

    for j in range(start, end + 1):
        total += code[j]
    for j in range(i):
        res[j] = total
        total -= code[start]
        start += 1
        if start >= i:
            start = 0
        end += 1
        if end >= i:
            end = 0
        total += code[end]

    return res
