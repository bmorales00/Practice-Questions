# Time Complexity: O(n) || Space COmplexity: O(n)

from typing import List


def twoSum(nums: List[int], target: int) -> List[int]:
    mapper = {}

    for i in range(len(nums)):
        if target - nums[i] in mapper:
            return [mapper[target - nums[i]], i]
        mapper[nums[i]] = i

    return []
