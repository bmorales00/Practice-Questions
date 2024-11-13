# Time Complexity: O(v+e) || Space Complexity:O(n)
from typing import Dict, List, Set


def validTree(n: int, edges: List[List[int]]) -> bool:
    if not edges:
        return False

    visited = {}

    for edge in edges:
        val1 = edge[0]
        val2 = edge[1]
        if val1 not in visited:
            visited[val1] = set()
        if val2 not in visited:
            visited[val2] = set()
        visited[val1].add(val2)
        visited[val2].add(val1)

    visit = set()

    return dfs(0, -1, visited, visit) and n == len(visit)


def dfs(node: int, prev: int, visited: Dict, hasVisited: Set) -> bool:
    if node in hasVisited:
        return False
    neigh = visited.get(node)
    hasVisited.add(node)
    for val in neigh:
        if val == prev:
            continue
        if not dfs(val, node, visited, hasVisited):
            return False

    return True
