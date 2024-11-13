# Time Complexity: O(n) || Space Complexity: O(n)
def isAnagram(s: str, t: str) -> bool:
    smap = {}
    tmap = {}

    for w in s:
        if w not in smap:
            smap[w] = 0

        smap[w] = smap[w] + 1

    for w in t:
        if w not in tmap:
            tmap[w] = 0
        tmap[w] = tmap[w] + 1

    return smap == tmap
