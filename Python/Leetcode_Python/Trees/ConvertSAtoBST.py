# Time Complexity: O(n) || Space Complexity: O(1) unless you count stack -> O(n)
from typing import List, Optional
from Treenode import TreeNode


def sortedArrayToBST(nums: List[int]) -> Optional[TreeNode]:
    if not nums:
        return None

    def dfs(start: int, end: int) -> Optional[TreeNode]:
        if start > end or end < start:
            return None

        mid = (end + start) // 2

        node = TreeNode(nums[mid], dfs(start, mid - 1), dfs(mid + 1, end))

        return node

    return dfs(0, len(nums) - 1)
