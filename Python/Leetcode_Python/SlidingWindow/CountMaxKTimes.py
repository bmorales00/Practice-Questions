# Time Complexity: O(n) || Space Complexity: O(1)
from typing import List


def countSubarrays(nums: List[int], k: int) -> int:
    if not nums:
        return 0

    maxVal = -1

    for i in nums:
        maxVal = max(maxVal, i)

    countVal = 0

    subs = 0

    l = 0
    r = 0
    prev = -1

    while r < len(nums):
        val = nums[r]
        if val == maxVal and prev != r:
            countVal += 1
            prev = r
        if countVal == k:
            subs += 1 + ((len(nums) - 1) - r)
            if nums[l] == maxVal:
                countVal -= 1
            l += 1
            if l > r:
                r = l
        else:
            r += 1
    return subs
