/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node, Node> map;
    public Node copyRandomList(Node head) {
        map = new HashMap<>();
        Node dummy = new Node(-1);
        Node cur = dummy;
        while (head != null) {
            cur.next = copy(head);
            cur = cur.next;
            head = head.next;
        }
        return dummy.next;  
    }
    public Node copy(Node head) {
        if (head == null) {
            return null;
        }
        if (map.containsKey(head)) {
            return map.get(head);
        }
        Node newNode = new Node(head.val);
        map.put(head, newNode);
        newNode.next = copy(head.next);
        newNode.random = copy(head.random);
        return newNode;
    }
}
