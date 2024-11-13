# Time Complexity: O(n) || Space Complexity:O(n)
from typing import List


def dailyTemp(temp: List[int]) -> List[int]:
    if not temp:
        return []

    vals = []
    indexes = []
    res = [0] * len(temp)

    vals.append(temp[0])
    indexes.append(0)
    for i in range(1, len(temp)):
        val = temp[i]
        while vals and val > vals[-1]:
            vals.pop(-1)
            j = indexes.pop(-1)
            res[j] = i - j

        vals.append(val)
        indexes.append(i)

    return res
