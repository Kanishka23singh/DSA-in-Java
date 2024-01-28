public class Solution {
    public static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node forw = curr.next;
            curr.next = prev;

            prev = curr;
            curr = forw;
        }
        return prev; // The new head is the previous last node
    }
}