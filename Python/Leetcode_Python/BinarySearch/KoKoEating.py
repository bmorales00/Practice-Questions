from typing import List


def minEatingSpeed(piles: List[int], h: int) -> int:
    if not piles:
        return -1

    small = 1000000001
    big = -1

    for val in piles:
        small = min(small, val)
        big = max(big, val)

    minInt = 1000000001
    while small <= big:
        mid = (big+small)//2
        i = 0
        for val in piles:
            if val <= mid:
                i+=1
            elif (val % mid == 0):
                i+= val//mid
            else:
                i+=(val//mid)+1

        if i == h:
            minInt = min(minInt, mid)
            big = mid-1

        elif i < h:
            big = mid -1
        else:
            small = mid+1

    return minInt
