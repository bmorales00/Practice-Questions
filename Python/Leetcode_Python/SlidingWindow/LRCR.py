def characterReplacement(s: str, k: int) -> int:
    if not s:
        return -1

    sz = len(s)
    alph = [0] * 26

    l = 0
    r = 0
    res = 0
    alph[ord(s[r]) - 65] += 1
    maxf = 1
    while r < sz:
        cond = ((r - l) + 1) - maxf <= k
        if cond:
            res = max(res, ((r - l) + 1))
            r += 1
            if r < sz:
                rch = ord(s[r]) - 65
                alph[rch] += 1
                maxf = max(maxf, alph[rch])
        else:
            lch = ord(s[l]) - 65
            alph[lch] -= 1
            l += 1

    if (r - l) - maxf <= k:
        res = max(res, ((r - l)))
    return res


print(characterReplacement("AABABBA", 1))
