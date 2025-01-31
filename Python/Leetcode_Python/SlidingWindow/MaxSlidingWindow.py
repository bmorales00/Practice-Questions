# Monotonically Decreasing Queue: Time Complexity: O(n) || Space Complexity: O(n)
from collections import deque
from typing import List


def maxSlidingWindow(nums: List[int], k: int) -> List[int]:
    if not nums:
        return []

    de = deque([])

    de.append(nums[0])
    res = []

    l = 0
    r = 1

    while r < k:
        while de and nums[r] > de[-1]:
            de.pop()
        de.append(nums[r])
        r += 1
    res.append(de[0])
    while r < len(nums):
        if de and de[0] == nums[l]:
            de.popleft()
        l += 1
        while de and nums[r] > de[-1]:
            de.pop()
        de.append(nums[r])
        r += 1
        res.append(de[0])
    return res
