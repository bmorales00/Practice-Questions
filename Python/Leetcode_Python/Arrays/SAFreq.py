# Time Complexity: O(nlogn) || Space Complexity: O(n)
from typing import List


def frqSort(nums: List[int]) -> List[int]:
    if not nums:
        return []
    res = []
    mapper = dict()
    for i in nums:
        if i not in mapper:
            mapper[i] = 0
        mapper[i] += 1

    mapper = sorted(mapper.items(), key=lambda item: (item[1], -item[0]))
    for m in mapper:
        res.extend([m[0]] * m[1])
    print(res)
    return res


n = [2, 3, 1, 3, 2]
frqSort(n)
