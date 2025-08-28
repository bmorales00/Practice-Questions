from typing import List


def minOperations(logs: List[str]) -> int:
    if not logs:
        return 0
    count = 0

    for log in logs:
        if log == "../":
            if count > 0:
                count -= 1
        elif log == "./":
            continue
        else:
            count += 1

    return count
