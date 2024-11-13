def checkInclusion(s1: str, s2: str) -> bool:
    if not s1 or not s2:
        return False
    if len(s1) > len(s2):
        return False

    s1Alph = [0] * 26
    s2Alph = [0] * 26

    for i in range(len(s1)):
        s1Alph[ord(s1[i]) - 97] += 1
        s2Alph[ord(s2[i]) - 97] += 1

    l = 0
    r = len(s1) - 1

    while r < len(s2):
        if s1Alph == s2Alph:
            return True
        if r == len(s2) - 1:
            break

        s2Alph[ord(s2[l]) - 97] -= 1
        l += 1
        r += 1
        s2Alph[ord(s2[r]) - 97] += 1

    return False
