# Time Complexity: O(n) || Space Complexity: O(1)
from typing import List


def trap(height: List[int]) -> int:
    if not height:
        return -1

    s = 0
    e = len(height) - 1

    trapped = 0
    goingLeft = False
    index = -1
    smallVal = -1

    while s < e:

        if height[s] <= height[e]:
            index = s + 1
            smallVal = height[s]
            goingLeft = False
        else:
            index = e - 1
            smallVal = height[e]
            goingLeft = True
        if goingLeft:
            while index > s and smallVal > height[index]:
                trapped += smallVal - height[index]
                index -= 1
            e = index
        else:
            while index < e and smallVal > height[index]:
                trapped += smallVal - height[index]
                index += 1
            s = index

    return trapped
