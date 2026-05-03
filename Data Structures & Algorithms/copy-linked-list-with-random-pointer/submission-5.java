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
        dummy.next = head;
        Node cur = dummy;
        while (head != null) {
            cur.next = copy(head);
            cur = cur.next;
            head = head.next;
        }
        return dummy.next;
    }
    private Node copy(Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        newNode.next = copy(node.next);
        newNode.random = copy(node.random);
        return newNode;
    }
}
