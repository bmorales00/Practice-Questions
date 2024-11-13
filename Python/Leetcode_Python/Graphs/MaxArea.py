from typing import List


def maxAreaofIsland(grid: List[List[int]]) -> int:
    if not grid:
        return 0

    m = len(grid)
    n = len(grid[0])

    max_area = 0
    for r in range(m):
        for c in range(n):
            if grid[r][c] == 1:
                max_area = max(max_area, dfs(grid, m, n, r, c))

    return max_area


def dfs(grid: List[List[int]], m: int, n: int, r: int, c: int) -> int:
    if r < 0 or c < 0 or r >= m or c >= n or grid[r][c] == 0:
        return 0

    grid[r][c] = 0

    return (
        dfs(grid, m, n, r - 1, c)
        + dfs(grid, m, n, r + 1, c)
        + dfs(grid, m, n, r, c - 1)
        + dfs(grid, m, n, r, c + 1)
        + 1
    )
