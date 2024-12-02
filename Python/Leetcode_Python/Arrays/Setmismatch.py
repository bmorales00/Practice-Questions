# Time Complexity: O(n) || Space Complexity:O(n)
from typing import List


def findErrorNums(nums: List[int]) -> List[int]:
    if not nums:
        return []

    nums2 = [0] * (len(nums) + 1)
    res = []

    for num in nums:
        nums2[num] += 1
        if nums2[num] == 2:
            res.append(num)

    for num in range(1,len(nums2)):
        if nums2[num] == 0:
            res.append(num)
            return res

    return res
