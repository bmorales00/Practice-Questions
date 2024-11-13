def longestCommonSubSequence(text1: str, text2: str) -> int:
    if not text1 or not text2:
        return 0

    if len(text1) > len(text2):
        temp = text1
        text1 = text2
        text2 = temp

    res = [[0 for _ in range(len(text1) + 1)] for _ in range(len(text2) + 1)]

    for i in range(len(text2) - 1, -1, -1):
        for j in range(len(text1) - 1, -1, -1):
            if text2[i] == text1[j]:
                res[i][j] = res[i + 1][j + 1] + 1
            else:
                res[i][j] = max(res[i + 1][j], res[i][j + 1])

    return res[0][0]


longestCommonSubSequence("abcde", "ace")
