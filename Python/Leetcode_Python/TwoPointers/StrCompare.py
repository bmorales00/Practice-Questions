# Time Complexity: O(s) + O(t) || Space Complexity: O(s) + O(t)
def backSpaceCompare(s: str, t: str) -> bool:
    if not s or not t:
        return False

    res_s = []
    res_t = []

    for char in s:
        if len(res_s) == 0 and char == "#":
            continue

        if char == "#":
            res_s.pop()
        else:
            res_s.append(char)

    for char in t:
        if len(res_t) == 0 and char == "#":
            continue

        if char == "#":
            res_t.pop()
        else:
            res_t.append(char)

    return res_s == res_t
