class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            // No middle node to delete in a list with 0 or 1 node
            return null;
        }

        ListNode s = head;
        ListNode f =  head;

        f = f.next.next; // So we skip slow and just move fast.
        while(f != null && f.next != null){ // second middle
            s = s.next;
            f = f.next.next;
        }
        s.next = s.next.next;

        return head;
    }
}
// So Basically we want slow to end 1 step before the middle node. 
// So we will skip 1 step of slow.