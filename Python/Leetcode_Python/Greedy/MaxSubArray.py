from typing import List


def maxSubArray(nums: List[int]) -> int:
    if not nums:
        return 0
    if len(nums) == 1:
        return nums[0]
    res = nums[0]
    maxSoFar = 0

    for val in nums:
        if maxSoFar < 0:
            maxSoFar = 0

        maxSoFar += val
        res = max(res, maxSoFar)
    return res
