from typing import List


def majorityElement(nums: List[int]) -> List[int]:
    if not nums:
        return []

    maj = len(nums) // 3
    nums.sort()
    res = []
    p1 = 0
    while p1 < len(nums):
        p2 = p1
        while p2 + 1 < len(nums) and nums[p2 + 1] == nums[p1]:
            p2 += 1
        if (p2 - p1) + 1 > maj:
            res.append(nums[p1])
        p1 = p2 + 1
    return res
