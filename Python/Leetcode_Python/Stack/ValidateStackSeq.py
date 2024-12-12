from typing import List


def validateStackSeq(pushed: List[int], popped: List[int]) -> bool:
    if not pushed or not popped:
        return False

    size = len(pushed)
    ad = []

    i = 1
    j = 0

    while i < size and j < size:
        if pushed[i] == popped[j]:
            i += 1
            j += 1
            continue
        if ad[-1] == popped[j]:
            ad.pop()
            j += 1
        else:
            ad.append(pushed[i])
            i += 1

    while j < size and ad[-1] == popped[j]:
        ad.pop()
        j += 1

    return len(ad) == 0

