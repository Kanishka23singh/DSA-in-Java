public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        while(p1 != p2){
            p1 = (p1 == null) ? headB : p1.next;
            p2 = (p2 == null) ? headA : p2.next;
        }
        return p1; //  return p2; 
    }
}

/*public class Solution {
    public static int findIntersection(Node firstHead, Node secondHead) {
        // Create pointers for both linked lists
        Node pointer1 = firstHead;
        Node pointer2 = secondHead;

        // Traverse both linked lists until they intersect or reach the end
        while (pointer1 != pointer2) {
            // Reset to the beginning of the list if it's null
            if (pointer1 == null) {
                pointer1 = secondHead;
            }
            if (pointer2 == null) {
                pointer2 = firstHead;
            }

            // Move the first pointer to the next node
            pointer1 = pointer1.next;

            // Move the second pointer to the next node
            pointer2 = pointer2.next;
        }

        // Return the intersection point or -1 if there is no intersection
        return (pointer1 == null) ? -1 : pointer1.data;
    }
}
*/