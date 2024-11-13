from typing import List


def pacificAtlantic(heights: List[List[int]]) -> List[List[int]]:
    if not heights:
        return []

    pac = set()
    atl = set()

    r = len(heights)
    c = len(heights[0])

    for i in range(c):
        dfs(0, i, pac, heights)
        dfs(r - 1, i, atl, heights)
    for j in range(r):
        dfs(j, 0, pac, heights)
        dfs(j, c - 1, atl, heights)

    res = [list(tup) for tup in pac.intersection(atl)]
    return res


def dfs(row: int, col: int, visited: set, heights: List[List[int]]):
    if (row, col) in visited:
        return

    visited.add((row, col))

    val = heights[row][col]

    if row - 1 >= 0 and heights[row - 1][col] >= val:
        dfs(row - 1, col, visited, heights)
    if row + 1 < len(heights) and heights[row + 1][col] >= val:
        dfs(row + 1, col, visited, heights)
    if col - 1 >= 0 and heights[row][col - 1] >= val:
        dfs(row, col - 1, visited, heights)
    if col + 1 < len(heights[0]) and heights[row][col + 1] >= val:
        dfs(row, col + 1, visited, heights)
