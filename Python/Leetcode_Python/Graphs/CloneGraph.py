from typing import Optional

from Graphs.Node import Node


def cloneGraph(node: Optional[Node]) -> Optional[Node]:
    visited = {}
    self.clone(node, visited)
    new_node = visited.get(node)

    return  new_node
def clone(self, node, visited:dict):
    current = node
    if current is None:
        return
    if current in visited:
        return

    visited[current] = Node(current.val, [])
        for n in current.neighbors:
            self.clone(n, visited)
            visited.get(current).neighbors.append(visited.get(n))
    
