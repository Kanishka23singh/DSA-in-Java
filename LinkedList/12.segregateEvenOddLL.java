public class Solution {
    public static Node segregateEvenOdd(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node oddHead = new Node(0); // Dummy node for the head of odd list
        Node evenHead = new Node(0); // Dummy node for the head of even list


        Node oddTail = oddHead;
        Node evenTail = evenHead;


        while (head != null) {  
            if (head.data % 2 == 0) {
                evenTail.next = head;
                evenTail = evenTail.next;
            } else {
                oddTail.next = head;
                oddTail = oddTail.next;
            }
            head = head.next;
        }

        evenTail.next = oddHead.next;
        oddTail.next = null;

        return evenHead.next;
    }
}