from typing import List


def encode(strs: List[str]) -> str:
    if not strs:
        return ""

    res = ""
    for word in strs:
        enc = "|" + str(len(word)) + word
        res += enc

    return res


def decode(s: str) -> List[str]:
    if not s:
        return []

    i = 0
    res = []
    while i < len(s):
        val_index = i + 1
        val = int(s[val_index])
        word = s[val_index + 1 : val_index + val + 1]
        res.append(word)
        i = val_index + val + 1
    return res


if __name__ == "__main__":
    res = encode(["neet", "code", "love", "you"])
    print(res)
    print(decode(res))
