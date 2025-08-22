from typing import List


def majorityElement(nums: List[int]) -> int:
    if not nums:
        return 1000000001

    maj = len(nums) // 2
    nums.sort()
    res = 0
    p1 = 0
    while p1 < len(nums):
        p2 = p1
        while p2 + 1 < len(nums) and nums[p2 + 1] == nums[p1]:
            p2 += 1
        if (p2 - p1) + 1 > maj:
            maj = (p2 - p1) + 1
            res = nums[p1]
        p2 += 1
        p1 = p2
    return res
