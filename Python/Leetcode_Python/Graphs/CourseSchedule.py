from typing import Dict, List


def canFinish(numCourses: int, prerequisites: List[List[int]]) -> bool:
    if not prerequisites or numCourses == 1:
        return True
    prerequisites.sort(key=lambda x: x[1])
    mapper = {}
    visited = set()

    for course in prerequisites:
        pre = course[1]
        post = course[0]
        if (post in mapper and pre in mapper.get(post)) or pre == post:
            return False
        if pre not in mapper:
            mapper[pre] = set()
        mapper[pre].add(post)

    for num in range(numCourses):
        if num not in mapper:
            continue
        if not dfs(num, set(), visited, mapper):
            print(f"{num} is not good\n, {visited}, {mapper.get(num)}\n")
            return False
        print(f"{num} is good \n")

    return True


def dfs(num: int, prev: set, visited: set, mapper: Dict) -> bool:
    if num in prev:
        return False
    if num not in mapper or num in visited:
        return True
    neigh = mapper.get(num)
    prev.add(num)
    for n in neigh:
        if not dfs(n, prev, visited, mapper):
            return False

    visited.add(num)
    return True
