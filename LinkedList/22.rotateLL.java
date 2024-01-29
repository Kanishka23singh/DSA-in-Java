class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        // Calculation length of linked list
        ListNode temp = head;
        int len = 1;
        while(temp.next != null){
            temp = temp.next;
            len++;
        }
        if(k % len == 0) return head;

        k = k % len; //when k is more than length of list
        temp.next = head; //link last node to first node
        k = len - k; //to get end of the list
        // Or while(k-- > 0) temp = temp.next;
        for(int i = 0; i < k; i++){
            temp = temp.next;
        }
        //breaking last node link and pointing to NULL
        head = temp.next;
        temp.next = null;

        return head;
    }
}