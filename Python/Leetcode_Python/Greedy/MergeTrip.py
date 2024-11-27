# Time Complexity: O(n) || Space Complexity: O(1)
from typing import List


def mergeTriplets(self, triplets: List[List[[int]]], target: List[int]) -> bool:
    if not triplets:
        return False

    res = [0, 0, 0]

    for trip in triplets:
        a = trip[0]
        b = trip[1]
        c = trip[2]
        x = target[0]
        y = target[1]
        z = target[2]
        if a <= x and b <= y and c <= z:
            res[0] = max(a, res[0])
            res[1] = max(b, res[1])
            res[2] = max(c, res[2])
        if res == target:
            return True

    return res == target
