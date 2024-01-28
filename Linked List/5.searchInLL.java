public class Solution {
    public static int searchInLinkedList(Node head, int k) {
        // Write Your Code Here.

        while (head != null) {
            if (head.data == k) {
                return 1;
            }
            else
            head = head.next;
        }
        return 0;
    }
}