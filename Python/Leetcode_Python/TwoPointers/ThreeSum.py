# Time Complexity: O(n^2) || Space Complexity: O(n)
from typing import List


def threesum(nums: List[int]) -> List[List[int]]:
    if not nums:
        return []

    nums.sort()

    res = []
    visited = set()
    for i in range(len(nums) - 2):
        checker = set()
        target = 0 - nums[i]
        for j in range(i + 1, len(nums)):
            k = target - nums[j]
            if k in checker:
                t = (nums[i], k, nums[j])
                if t not in visited:
                    visited.add(t)
                    res.append([nums[i], k, nums[j]])
            checker.add(nums[j])
    return res


def threesum2(nums: List[int]) -> List[List[int]]:
    if not nums:
        return []

    nums.sort()
    res = []
    for i in range(len(nums) - 2):
        if i > 0 and nums[i] == nums[i - 1]:
            continue
        target = -nums[i]

        l = i + 1
        r = len(nums) - 1

        while l < r:
            if nums[l] + nums[r] == target:
                res.append([nums[i], nums[l], nums[r]])
                while l < r and nums[l] == nums[l + 1]:
                    l += 1
                while l < r and nums[r] == nums[r - 1]:
                    r -= 1
                l += 1
                r -= 1
            elif nums[l] + nums[r] < target:
                while l < r and nums[l] == nums[l + 1]:
                    l += 1
                l += 1
            elif nums[l] + nums[r] > target:
                while l < r and nums[r] == nums[r - 1]:
                    r -= 1
                r -= 1

    return res
