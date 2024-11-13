# Time Complexity: O(2^n) || Space Complexity: O(n)
from typing import List


def generateParenthesis(n: int) -> List[str]:
    if n <= 0:
        return []

    res = []

    dfs(res, "", n, n, n * 2)

    return res


def dfs(res: List[str], p: str, left: int, right: int, size: int) -> None:
    if left > right:
        return

    if left > 0:
        dfs(res, p + "(", left - 1, right, size)

    if right > 0:
        dfs(res, p + ")", left, right - 1, size)

    if len(p) == size:
        res.append(p)


generateParenthesis(3)
