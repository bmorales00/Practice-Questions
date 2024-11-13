def getSum(a: int, b: int) -> int:
    mask = 0xFFFFFFFF
    while b & mask > 0:
        temp = a & b
        a = a ^ b
        b = temp << 1
    return (a & mask) if b > 0 else a
