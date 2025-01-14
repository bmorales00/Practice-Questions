# Time Complexity: O(n) || Space Complexity: O(1)
from typing import List


def numSubarraysWithSum(nums: List[int], goal: int) -> int:
    if not nums or not goal:
        return -1

    l = 0
    r = 0

    subs1 = 0
    subs2 = 0

    curr = 0

    while r < len(nums):
        val = nums[r]
        if curr + val <= goal:
            subs1 += (r - l) + 1
            r += 1
            curr += val
        else:
            curr -= nums[l]
            l += 1
    if goal != 0:
        r = 0
        l = 0
        while r < len(nums):
            val = nums[r]
            if curr + val <= goal - 1:
                subs2 += (r - l) + 1
                r += 1
                curr += val
            else:
                curr -= nums[l]
                l += 1
    return subs1 - subs2
