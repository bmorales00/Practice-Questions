# Space Complexity: O(n)
class LRUCache:
    class Node:
        def __init__(self, key, val, prev=None, next=None) -> None:
            self.key = key
            self.val = val
            self.prev = prev
            self.next = next

    def __init__(self, capacity: int) -> None:
        self.capacity = capacity
        self.mapper = dict()
        self.curr_size = 0
        self.head = None
        self.tail = None

    # Time Complexity: O(1)
    def get(self, key: int) -> int:
        if not self.mapper.get(key):
            return -1
        node = self.mapper[key]
        self.swap(node)
        return node.val

    def put(self, key: int, value: int) -> None:
        if self.curr_size == 0:
            node = self.Node(key, value)
            self.head = self.tail = self.mapper[key] = node
            self.curr_size += 1
            return

        if key in self.mapper:
            temp = self.mapper[key]
            temp.val = value
            self.swap(temp)
            return

        if self.curr_size == self.capacity:
            self.mapper.pop(self.tail.key)
            if self.curr_size == 1:
                node = self.Node(key, value)
                self.head = self.tail = self.mapper[key] = node
                return
            self.tail = self.tail.prev
            self.tail.next = None

        node = self.Node(key, value)

        self.mapper[key] = self.head.prev = node
        node.next = self.head
        self.head = node

        if self.curr_size < self.capacity:
            self.curr_size += 1

    # Time Complexity:O(1)
    def swap(self, node: Node) -> None:
        if node.key == self.head.key:
            return
        if node.key == self.tail.key:
            self.tail = self.tail.prev
            self.tail.next = node.prev = None
            node.next = self.head
            self.head.prev = node
            self.head = node
            return
        left = node.prev
        right = node.next
        left.next = right
        right.prev = left
        node.prev = None
        node.next = self.head
        self.head.prev = node
        self.head = node
        return


test = LRUCache(1)

test.put(2, 1)
test.get(2)
test.put(3, 2)
test.get(2)
test.get(3)
