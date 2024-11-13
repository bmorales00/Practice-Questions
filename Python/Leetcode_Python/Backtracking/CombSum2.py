# Time Complexity: O(2^n * k) || Space Complexity: O(2^n * k) k being the average size of the comb
from typing import List


def combinationSum(candidates: List[int], target: int) -> List[List[int]]:
    if not candidates:
        return []

    candidates.sort()
    res = []

    def backtrack(start: int, comb_sum: int, comb: List[int]) -> None:
        if comb_sum > target:
            return
        if comb_sum == target:
            res.append(list(comb))
            return

        i = start

        while i < len(candidates):
            if comb_sum + candidates[i] <= target:
                comb.append(candidates[i])
                backtrack(i + 1, comb_sum + candidates[i], comb)
                comb.pop()
                while i < len(candidates) - 1 and candidates[i] == candidates[i + 1]:
                    i += 1

            i += 1

    backtrack(0, 0, [])
    BaseException
    return res


print(combinationSum([10, 1, 2, 7, 6, 1, 5], 8))
