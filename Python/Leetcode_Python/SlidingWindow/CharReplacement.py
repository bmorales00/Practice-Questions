def characterReplacement(s: str, k: int) -> int:
    if not s:
        return 0

    # Maybe add an edge case for len(str) ==2 and k ==1

    mapper = {}

    for char in s:
        if char not in mapper:
            mapper[char] = 0
        mapper[char] += 1

    j = len(s) -1

    return 0
