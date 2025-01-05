def arrangeCoins(n: int) -> int:
    if not n:
        return -1

    left = n

    for i in range(1, n + 1):
        if left > i:
            left -= i
        else:
            return i

    return left
