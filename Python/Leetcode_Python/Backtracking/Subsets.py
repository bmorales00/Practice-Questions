# Time Complexity: O(2^n) || Space Complexity: O(n)
from typing import List


def subsets(nums: List[int]) -> List[List[int]]:
    if not nums:
        return []
    res = []
    backtrack(nums, res, list(), 0)
    return res


def backtrack(
    nums: List[int],
    res: List[List[int]],
    current: List[int],
    index: int,
) -> None:

    res.append(current.copy())

    size = len(nums)

    if index >= size:
        return

    for i in range(index, size):
        val = nums[i]
        current.append(val)
        backtrack(nums, res, current, i + 1)
        current.pop()
