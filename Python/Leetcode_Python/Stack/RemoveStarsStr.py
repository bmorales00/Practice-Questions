def removeStars(s: str) -> str:
    if not s:
        return ""

    res = []

    for ch in s:
        if ch == "*":
            res.pop()
        else:
            res.append(ch)

    return "".join(res)
