# Time Complexity: O(n) || Space Complexity: O(n)
from typing import Dict, List


def countComponents(n: int, edges: List[List[int]]) -> int:
    if not edges:
        return n
    if n == 1:
        return 1

    mapper = {}
    visited = set()
    count = 0
    for edge in edges:
        if edge[0] not in mapper:
            mapper[edge[0]] = []
        if edge[1] not in mapper:
            mapper[edge[1]] = []
        mapper[edge[0]].append(edge[1])
        mapper[edge[1]].append(edge[0])

    for i in range(n):
        if i in mapper and i not in visited:
            dfs(i, -1, visited, mapper)
            count += 1

    return count


def dfs(value: int, prev: int, visited: set, mapper: Dict):

    neigh = mapper.get(value)
    if value in visited:
        return
    visited.add(value)
    for n in neigh:
        if n == prev:
            continue
        dfs(n, visited, mapper)
