from typing import List


def groupAnagrams(strs: List[str]) -> List[List[str]]:
    if not strs:
        return [[]]

    mapper = {}

    for word in strs:
        chars = [0] * 26
        for l in word:
            chars[ord(l) - 97] += 1
        t = tuple(chars)
        if t not in mapper:
            mapper[t] = []
        mapper[t].append(word)

    res = []

    for k, v in mapper.items():
        res.append(v)
    return res
