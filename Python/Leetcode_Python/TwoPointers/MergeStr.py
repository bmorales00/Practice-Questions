def mergeAlternately(word1: str, word2: str) -> str:
    if not word1 or not word2:
        return ""

    res = [""] * (len(word1) + len(word2))

    i = 0
    j = 0
    r = 0
    while i < len(word1) and j < len(word2):
        res[r] = word1[i]
        i += 1
        r += 1
        res[r] = word2[j]
        j += 1
        r += 1

    while i < len(word1):
        res[r] = word1[i]
        r += 1
        i += 1
    while j < len(word2):
        res[r] = word2[j]
        r += 1
        j += 1
    return "".join(res)
