class Solution {

    public static int length(ListNode node){
        int len = 0;
        ListNode curr = node;
        while(curr != null){
            curr = curr.next;
            len++;
        }
        return len;
    }

    static ListNode th = null; // Temporary Head
    static ListNode tt = null; // Temporary tail

    public static void addFirst(ListNode node){
        if (th == null) {
            th = node;
            tt = node;
        }
        else {
            node.next = th;
            th = node;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k <= 1){
            return head;
        }

        ListNode oh = null; // Origginal Head
        ListNode ot = null; // Original Tail

        int len = length(head);
        ListNode curr = head;
        while(len >= k){
            int tempk = k;
            while(tempk > 0){    
                ListNode next = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = next;
                tempk--;
            }

            if(oh == null){
                oh = th;
                ot = tt;
            }
            else{
                ot.next = th;
                ot = tt;
            }

            th = null;
            tt = null;
            len -= k;
        }
        ot.next = curr;
        return oh;
    }
}
