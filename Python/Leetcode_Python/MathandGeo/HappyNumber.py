def isHappy(n: int) -> bool:
    if not n or n <= 0:
        return False

    nstr = str(n)

    # if len(nstr) == 1 and n != 1:
    #     return False
    visited = set()
    while n != 1:
        if n in visited:
            return False
        visited.add(n)
        total = 0

        for i in range(len(nstr)):
            num = int(nstr[i])
            total += num * num
        n = total
        nstr = str(total)

    return True


print(isHappy(9))
