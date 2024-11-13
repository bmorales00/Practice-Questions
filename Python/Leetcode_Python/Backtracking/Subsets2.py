# Time Complexity: O(2^N * N) || Space Complexity: O(N)
from typing import Set, List


def subsetsWithDup(nums: List[int]) -> List[List[int]]:
    if not nums:
        return []

    nums.sort()

    res = []
    backtrack(nums, res, 0, set(), list())

    return res


def backtrack(
    nums: List[int], res: List[List[int]], index: int, visited: Set, current: List[int]
) -> None:
    temp = tuple(current)

    if temp not in visited:
        visited.add(temp)
        res.append(current.copy())

    size = len(nums)

    if index >= size:
        return

    for i in range(index, size):
        current.append(nums[i])
        backtrack(nums, res, i + 1, visited, current)
        current.pop()
