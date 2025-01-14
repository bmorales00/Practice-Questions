# Time Complexity: O(n) || Space Complexity: O(n)
from typing import List


def maxSubarrayLength(nums: List[int], k: int) -> int:
    if not nums:
        return -1

    mapper = dict()

    l = 0
    r = 0
    currSub = 0
    maxSub = 0

    while r < len(nums):
        val = nums[r]

        if val not in mapper:
            mapper[val] = 1
            currSub += 1
            r += 1
        elif val in mapper and mapper[val] < k:
            mapper[val] += 1
            currSub += 1
            r += 1
        elif val in mapper and mapper[val] == k:
            while l < r and nums[l] != val:
                currSub -= 1
                mapper[nums[l]] -= 1
                l += 1
            l += 1
        maxSub = max(maxSub, currSub)

    return maxSub
