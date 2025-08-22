# Time Complexity: O(nlogn) || Space Complexity: O(n)
from typing import List


def sortPeople(names: List[str], heights: List[int]) -> List[str]:
    if not names or not heights:
        return []
    res = []
    mapper = dict()
    for i in range(len(names)):
        mapper[heights[i]] = names[i]
    mapper = sorted(mapper.items(), key=lambda item: item[0], reverse=True)

    for m in mapper:
        res.append(m[1])
    return res


n = ["M", "J", "E"]
h = [180, 165, 170]

sortPeople(n, h)
