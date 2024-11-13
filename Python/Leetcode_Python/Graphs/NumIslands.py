#Time Complexity: O(rc) || Space Complexity: O(rc)
from typing import List


def numIslands(grid: List[List[str]]) -> int:
    if not grid:
        return 0

    size = len(grid)
    count = 0
    for i in range(size):
        r = len(grid[0])
        for j in range(r):
            if grid[i][j] == "1":
                count += 1
                dfs(i, j, grid)
    return count


def dfs(row: int, col: int, grid: List[List[str]]) -> None:
    if (
        row < 0
        or col < 0
        or row >= len(grid)
        or col >= len(grid[0])
        or grid[row][col] == "0"
    ):
        return

    if grid[row][col] == "1":
        grid[row][col] = "0"
    dfs(row - 1, col, grid)
    dfs(row + 1, col, grid)
    dfs(row, col - 1, grid)
    dfs(row, col + 1, grid)
