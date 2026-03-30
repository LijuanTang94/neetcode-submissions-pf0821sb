# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        cur = head
        while n > 0 and cur:
            cur = cur.next
            n -= 1
        slow = dummy
        while cur:
            slow = slow.next
            cur = cur.next
        slow.next = slow.next.next
        return dummy.next