# Time Complexity: O(n!) || Space Complexity: O(n)
from typing import List, Set


def permute(nums: List[int]) -> List[List[int]]:
    if not nums:
        return []

    size = len(nums)
    res = []

    backtrack(nums, res, size, [], set())

    return res


def backtrack(
    nums: List[int],
    res: List[List[int]],
    size: int,
    temp: List[int],
    visited: Set,
) -> None:
    if len(temp) == size:
        res.append(temp.copy())
        return
    for i in range(size):
        if nums[i] in visited:
            continue
        visited.add(nums[i])
        temp.append(nums[i])
        backtrack(nums, res, size, temp, visited)
        visited.discard(nums[i])
        temp.pop(-1)


permute([1, 2, 3])
