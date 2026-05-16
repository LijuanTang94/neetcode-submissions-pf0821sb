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
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            Node nxt = cur.next;
            cur.next = newNode;
            newNode.next = nxt;
            cur = nxt;
        }
        cur = head;
        Node copy = cur.next;
        while (cur != null) {
            copy = cur.next;
            copy.random = cur.random == null ? null: cur.random.next;
            cur = copy.next;
        }
        cur = head;
        Node dummy = new Node(-1);
        copy = cur.next;
        dummy.next = copy;
        while (cur != null) {
            Node nxt = copy.next;
            cur.next = nxt;
            copy.next = nxt == null ? null: nxt.next;
            cur = nxt;
            copy = cur == null ? null: cur.next;
        }
        return dummy.next;

    }
}
