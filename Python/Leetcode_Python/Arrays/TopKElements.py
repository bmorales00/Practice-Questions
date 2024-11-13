from typing import List


def topKFreq(nums: List[int], k: int) -> List[int]:
    if not nums:
        return []

    map1 = {}
    map2 = {}
    count = []
    res = []

    for val in nums:
        if val not in map1:
            map1[val] = 0
        map1[val] = map1[val] + 1

    for key, value in map1.items():
        if value not in map2:
            map2[value] = []
            count.append(value)
        map2[value].append(key)

    count.sort()
    while len(res) < k and len(count) > 0:
        val = count.pop()
        temp = map2[val]
        print(f"This is val {val}")
        print(f"This is temp {temp}")
        while len(temp) > 0 and len(res) < k:
            x = temp.pop()
            res.append(x)

    return res
