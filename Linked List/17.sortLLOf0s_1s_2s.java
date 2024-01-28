public class Solution
{
    public static Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head; // No sorting needed for empty or single-node list
        }

        Node zeroHead = new Node(0); // Dummy node for the 0s
        Node oneHead = new Node(0);  // Dummy node for the 1s
        Node twoHead = new Node(0);  // Dummy node for the 2s

        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;

        Node current = head;

        while (current != null) {
            if (current.data == 0) {
                zero.next = current;
                zero = zero.next;
            } else if (current.data == 1) {
                one.next = current;
                one = one.next;
            } else {
                two.next = current;
                two = two.next;
            }
            current = current.next;
        }

        // Connect the lists
        zero.next = oneHead.next;
        one.next = twoHead.next;
        two.next = null; // Set the end of the 2s list

        // Return the sorted list starting from the first 0 node
        return zeroHead.next;
    }
}