# Time Complexity: O(nm * n^4) || Space Complexity: O(n*m)

from typing import List, Set


def exist(board: List[List[str]], word: str) -> bool:
    if not board:
        return False

    m = len(board)
    n = len(board[0])
    for i in range(m):
        for j in range(n):
            if board[i][j] == word[0] and checker(board, word, 0, i, j, set()):
                return True

    return False


def checker(
    board: List[List[str]], word: str, char: int, r: int, c: int, visited: Set
) -> bool:
    if char >= len(word):
        return True
    if r < 0 or c < 0 or r >= len(board) or c >= len(board[0]):
        return False
    if word[char] != board[r][c] or (r, c) in visited:
        return False
    visited.add((r, c))

    if (
        not checker(board, word, char + 1, r - 1, c, visited)
        and not checker(board, word, char + 1, r + 1, c, visited)
        and not checker(board, word, char + 1, r, c - 1, visited)
        and not checker(board, word, char + 1, r, c + 1, visited)
    ):
        visited.discard((r, c))
        return False
    return True


print(
    exist(
        [["A", "B", "C", "E"], ["S", "F", "E", "S"], ["A", "D", "E", "E"]], "ABCESEEEFS"
    )
)
