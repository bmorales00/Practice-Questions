# Time Complexity: O(n) || Space Complexity: O(n)
def mergeTwoLists(list1: Optional[ListNode] , list2: Optional[Listnode])-> Optional[ListNode]:
    if(list1 is None):
        return list2
    if list2 is None:
        return list1
    if list1 is None and list2 is None:
        return None


    curr_l = list1
    curr_r = list2

    res = None

    if(curr_l.val <= curr_r.val):
        res= new ListNode(curr_l.val)
        curr_l = curr_l.next
    else:
        res = new ListNode(curr_r.val)
        curr_r = curr_r.next

    head = res
    while(curr_l is not None and curr_r is not None):
        if curr_l.val <= curr_r.val:
            head.next = new ListNode(curr_l.val)
            head = head.next
            curr_l = curr_l.next
        else:
            head.next = new ListNode(curr_r.val)
            head = head.next
            curr_r = curr_r.next

    if curr_l is None:
        head.next = curr_r
    else:
        head.next = curr_l

    return res




