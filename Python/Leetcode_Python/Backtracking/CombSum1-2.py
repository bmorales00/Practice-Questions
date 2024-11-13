# Time Complexity: O(2^t) || Space Complexity: O(2^t)
from typing import List


def combinationsSum(candidates: List[int], target: int) -> List[List[int]]:
    if not candidates:
        return []
    res = []

    def dfs(start, current_comb, current_sum):
        if current_sum == target:
            res.append(list(current_comb))
            return
        if current_sum > target:
            return

        for i in range(start, len(candidates)):
            current_comb.append(candidates[i])
            dfs(i, current_comb, current_sum + candidates[i])
            current_comb.pop()

    dfs(0, [], 0)
    return res


print(combinationsSum([2, 3, 6, 7], 7))
