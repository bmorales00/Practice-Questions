class MyCircularDeque:
    class Node:
        def __init__(self, val: int) -> None:
            self.val = val
            self.next = None
            self.prev = None

    def __init__(self, k: int) -> None:
        self.count = 0
        self.size = k
        self.head = None
        self.tail = None

    def isEmpty(self) -> bool:
        return self.count == 0

    def isFull(self) -> bool:
        return self.count == self.size

    def getFront(self) -> int:
        if not self.head:
            return -1

        return self.head.val

    def getRear(self) -> int:
        if not self.tail:
            return -1

        return self.tail.val

    def insertFront(self, value: int) -> bool:
        if self.isFull():
            return False
        node = self.Node(value)
        if not self.head:
            self.head = node
            self.tail = node
        else:
            node.next = self.head
            self.head.prev = node
            self.head = node
        self.count += 1
        return True

    def insertLast(self, value:int)->bool:
        if self.isFull():
            return False
        node = self.Node(value)
        if not self.head:
            self.head = node
            self.tail = node
        else:
            self.tail.next = node
            node.prev = self.tail
            self.tail = node
        self.count+=1
        return True

    def deleteFront(self) -> bool:
        if self.isEmpty():
            return False
        if self.count == 1:
            self.head = None
            self.tail = None
        else:
            temp = self.head.next
            temp.prev = None
            self.head.next = None
            self.head = temp
        self.count -= 1
        return True

    def deleteLast(self)->bool:
        if self.isEmpty():
            return False
        if self.count == 1:
            self.head = None
            self.tail = None
        else:
            temp = self.tail.prev
            self.tail.prev = None
            temp.next = None
            self.tail = temp
        self.count-=1
        return True

