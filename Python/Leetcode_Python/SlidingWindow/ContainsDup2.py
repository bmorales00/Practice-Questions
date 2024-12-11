from typing import List


def containsNearbyDuplicate(nums:List[int], k:int)->bool:
    if not nums:
        return False

    vals = dict()

    for i in range(len(nums)):
        num = nums[i]
        if num not in vals:
            vals[num] = i
            continue
        if i - vals[num] <= k:
            return True
        vals[num] = i

    return False

