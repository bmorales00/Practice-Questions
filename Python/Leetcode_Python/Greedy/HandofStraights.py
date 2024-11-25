from typing import List


def isNStraightHand(hand: List[int], groupSize: int) -> bool:
    if not hand or not groupSize:
        return False
    if len(hand) % groupSize != 0:
        return False

    vals = dict()
    smallest = 1000000001
    for val in hand:
        if val not in vals:
            vals[val] = 0
        if val < smallest:
            smallest = val
        vals[val] += 1
    count = 0
    while count != len(hand):
        if vals[smallest] == 0:
            curr = smallest
            while not (curr in vals and vals[curr] > 0):
                curr += 1
            smallest = curr
        curr = smallest
        for i in range(groupSize):
            if curr not in vals or vals[curr] == 0:
                return False
            vals[curr] -= 1
            curr += 1
            count += 1

    return True


