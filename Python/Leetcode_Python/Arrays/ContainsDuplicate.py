# Time Complexity: O(n) || Space Complexity O(n)
from typing import List


def hasDuplicate(nums: List[int]) -> bool:

    return not (len(set(nums)) == len(nums))
