# Time Complexity: O(n) || Space Complexity: O(1)
from typing import List


def maxArea(height: List[int]) -> int:
    if not height:
        return -1

    l = 0
    r = len(height) - 1
    maxOfHeight = 0
    while l < r:
        x = r - l
        y = min(height[l], height[r])
        maxOfHeight = max(maxOfHeight, x * y)
        if height[l] <= height[r]:
            l += 1
        else:
            r -= 1
    return maxOfHeight
