# Time Complexity: O(log(n*m)) || Space Complexity: O(1)
from typing import List


def searchMatrix(matrix: List[List[int]], target: int) -> bool:
    if not matrix:
        return False

    for map in matrix:
        if target >= map[0] and target <= map[-1]:
            return search(map, target)

    return False


def search(map: List[int], target: int) -> bool:

    start = 0
    end = len(map) - 1

    while start <= end:
        mid = (end + start) // 2

        if target == map[mid]:
            return True
        elif target < map[mid]:
            end = mid - 1
        else:
            start = mid + 1

    return False
