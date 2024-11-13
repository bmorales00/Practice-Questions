from typing import List, Set


def combinationsSum(candidates: List[int], target: int) -> List[List[int]]:
    if not candidates:
        return []
    # O(log n) Operation
    candidates.sort()

    res = []
    visited = set()

    backtrack(candidates, target, res, visited, [], [0] * 41, 0)

    return res


def backtrack(
    candidates: List[int],
    target: int,
    res: List[List[int]],
    visited: Set,
    cand: List[int],
    temp: List[int],
    current: int,
):
    if current > target:
        return
    if current == target:
        temp2 = tuple(temp)
        if temp2 not in visited:
            visited.add(temp2)
            res.append(cand.copy())
        return

    for i in range(len(candidates)):
        val = candidates[i]
        temp[val] += 1
        cand.append(val)
        backtrack(candidates, target, res, visited, cand, temp, current + val)
        temp[val] -= 1
        cand.pop(-1)


print(combinationsSum([2], 1))
