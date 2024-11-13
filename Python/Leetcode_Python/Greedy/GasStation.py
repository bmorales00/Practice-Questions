# Time Complexity: O(n) || Space Complexity: O(n)
from typing import List


def canCompleteCircuit(gas: List[int], cost: List[int]) -> int:
    if not gas or not cost:
        return -1

    total_gas = sum(gas)

    total_cost = sum(cost)
    if total_cost > total_gas:
        return -1

    curr_i = 0
    curr_sum = gas[0] - cost[0]
    for i in range(1, len(gas)):
        if curr_sum < 0:
            curr_i = i
            curr_sum = 0
        curr_sum += gas[i] - cost[i]

    if curr_sum >= 0:
        return curr_i

    return -1


canCompleteCircuit([1, 2, 3, 4, 5], [3, 4, 5, 1, 2])
