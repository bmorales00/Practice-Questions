# Time Complexity: O(V + E) || Space Complexity: O(V)

from typing import List, Optional


class Node:
    def __init__(
        self, val: Optional[int] = None, children: Optional[List["Node"]] = None
    ):
        self.val = val
        self.children = children


def postOrder(root: "Node") -> List[int]:
    res = []

    def dfs(root: "Node"):
        if not root:
            return

        if not root.children:
            res.append(root.val)
            return

        for n in root.children:
            dfs(n)
        res.append(root.val)

    return res
