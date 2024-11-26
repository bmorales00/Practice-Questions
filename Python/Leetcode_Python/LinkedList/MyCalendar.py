class MyCalendar:
    class Node:
        def __init__(self, x: int, y: int) -> None:
            self.start = x
            self.end = y
            self.next = None
            self.prev = None

    def __init__(self) -> None:
        self.head = None
        self.tail = None

    def book(self, startTime: int, endTime: int) -> bool:
        node = self.Node(startTime, endTime)
        if not self.head:
            self.head = node
            self.tail = node
            return True

        curr = self.head

        while curr:
            x = curr.start
            y = curr.end

            if startTime >= y and not curr.next:
                node = self.Node(startTime, endTime)
                node.prev = self.tail
                self.tail.next = node
                self.tail = node
                return True
            elif (startTime >= y and curr.next) and endTime <= curr.next.start:
                node = self.Node(startTime, endTime)
                temp = curr.next
                node.prev = curr
                node.next = temp
                temp.prev = node
                curr.next = node
                return True
            elif endTime <= x and not curr.prev:
                node = self.Node(startTime, endTime)
                curr.prev = node
                node.next = curr
                self.head = node
                return True
            curr = curr.next

        return False
