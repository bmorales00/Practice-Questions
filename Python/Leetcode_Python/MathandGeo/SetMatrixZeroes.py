# Time Complexity: O(mn) || Space Complexity: O(mn)
from typing import List


def setZeroes(matrix: List[List[int]]) -> None:
    if not matrix:
        return
    r = len(matrix)
    c = len(matrix[0])

    cords = []

    for i in range(r):
        for j in range(c):
            if matrix[i][j] == 0:
                cords.append([i, j])

    for cord in cords:
        up(matrix, cord[0] - 1, cord[1], r, c)
        down(matrix, cord[0] + 1, cord[1], r, c)
        left(matrix, cord[0], cord[1] - 1, r, c)
        right(matrix, cord[0], cord[1] + 1, r, c)


def up(matrix: List[List[int]], x: int, y: int, r: int, c: int) -> None:
    if x < 0 or y < 0 or x >= r or y >= c:
        return

    matrix[x][y] = 0
    up(matrix, x - 1, y, r, c)


def down(matrix: List[List[int]], x: int, y: int, r: int, c: int) -> None:
    if x < 0 or y < 0 or x >= r or y >= c:
        return

    matrix[x][y] = 0
    down(matrix, x + 1, y, r, c)


def left(matrix: List[List[int]], x: int, y: int, r: int, c: int) -> None:
    if x < 0 or y < 0 or x >= r or y >= c:
        return

    matrix[x][y] = 0
    left(matrix, x, y - 1, r, c)


def right(matrix: List[List[int]], x: int, y: int, r: int, c: int) -> None:
    if x < 0 or y < 0 or x >= r or y >= c:
        return

    matrix[x][y] = 0
    right(matrix, x, y + 1, r, c)
