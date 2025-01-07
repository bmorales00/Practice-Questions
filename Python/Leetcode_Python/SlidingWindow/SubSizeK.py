# Time Complexity: O(n) || Space Complexity:O(1)
from typing import List


def numOfSubarrays(arr:List[int], k:int, threshold:int)->int:
    
    head = 0
    tail = k-1
    curr = 0

    for i in range(k):
        curr+= arr[i]

    res = 1 if curr//k >= threshold else 0

    while tail+1 < len(arr):
        curr-=arr[head]
        head+=1
        tail+=1
        curr+=arr[tail]

        if curr//k>= threshold:
            res+=1

    return res
