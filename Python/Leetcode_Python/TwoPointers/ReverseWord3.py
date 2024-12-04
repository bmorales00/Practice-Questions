# Time Complexity: O(n) || Space Complexity: O(n)
def reverseWords(s: str) -> str:
    if not s:
        return " "

    l = s.split(" ")
    res = [m[::-1] for m in l]
    return "".join(res)


