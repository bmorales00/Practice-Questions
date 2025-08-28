# Time Complexity: O(n) || Space Complexity: O(n)
def clearDigits(s: str) -> str:
    if not s:
        return ""

    ele = []

    for ch in s:
        if ch.isdigit() and len(ele) > 0 and ele[-1].isalpha():
            ele.pop()
        else:
            ele.append(ch)

    return "".join(ele)
