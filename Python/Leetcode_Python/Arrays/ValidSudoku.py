# Time Complexity: O(9^2) || Space Complexity: O(9^2)
from typing import List


def isValidSudoku(board: List[List[str]]) -> bool:
    if not board:
        return False
    rows = dict()
    cols = dict()
    subBoxes = dict()

    for i in range(9):
        for j in range(9):
            if board[i][j] != ".":
                if i not in rows:
                    rows[i] = set()
                if j not in cols:
                    cols[j] = set()
                if ((i // 3), (j // 3)) not in subBoxes:
                    subBoxes[((i // 3), (j // 3))] = set()
                val = int(board[i][j])
                s1 = rows[i]
                s2 = cols[j]
                s3 = subBoxes[((i // 3), (j // 3))]
                if val in s1 or val in s2 or val in s3:
                    return False
                s1.add(val)
                s2.add(val)
                s3.add(val)

    return True
