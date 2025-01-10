#Time Complexity: O(n) || Space Complexity:O(1)
from typing import List


def subArrayProdLessThanK(nums:List[int], k:int)->int:
    if not nums:
        return -1

    prod = 1

    i = 0
    j = 0

    sub = 0

    while j< len(nums):

        if prod * nums[j] < k:
            prod*=nums[j]
            sub+= (j-i)+1
            j+=1
        elif prod * nums[j]>=k and i ==j:
            i+=1
            j+=1
        elif prod * nums[j] >=k:
            prod//=nums[i]
            i+=1

    return sub



