def guessNumber(n: int) -> int:
    if not n:
        return -1

    start = 0
    end = n

    while start < end:
        mid = (end + start) // 2

        isN = guess(mid)

        if isN == 0:
            return mid

        elif isN == 1:
            start = mid + 1
        else:
            end = mid - 1

    return start
