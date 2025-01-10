# Time Complexity: O(n) || Space Complexity: O(1)
from typing import List


def totalFruit(fruits:List[int])->int:
    if not fruits:
        return -1

    if len(fruits) ==1:
        return 1

    if len(fruits) ==2:
        return 2

    mapper = dict()

    j = 0
    res = 2
    i = 0

    while j <len(fruits):
        if fruits[j] not in mapper:
            mapper[fruits[j]] = 1
        elif fruits[j] in mapper:
            mapper[fruits[j]]+=1

        if len(mapper) == 2:
            total = 0
            for item in mapper.values():
                total+=item
            res = max(res, total)
        else:
            mapper[fruits[i]] -=1
            if mapper[fruits[i]] == 0:
                mapper.pop(fruits[i])
            i+=1
        j+=1
    return res
