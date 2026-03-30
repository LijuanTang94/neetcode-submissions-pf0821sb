"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        node_hash = {None: None}
        cur = head
        while cur:
            node_hash[cur] = Node(cur.val)
            cur = cur.next
        cur = head
        while cur:
            copy = node_hash[cur]
            copy.next = node_hash[cur.next]
            copy.random = node_hash[cur.random]
            cur = cur.next
        return node_hash[head]
