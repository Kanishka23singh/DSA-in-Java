class Solution {
    public Node copyRandomList(Node head) {
        Node iter = head;
        Node front = head;

        // Step 1: Insert copy nodes in between
        while (iter != null) {
            front = iter.next;
            Node copy = new Node(iter.val);
            copy.next = front;
            iter.next = copy;

            iter = front;
        }

        // Step 2: Connect random pointers
        iter = head;
        while(iter != null){
            if(iter.random != null){
                iter.next.random = iter.random.next;
            }
                iter = iter.next.next;
        }

        // Step 3: Seperate deep copy LL and original LL
        Node dummy = new Node(0);
        Node copy = dummy;
        iter = head;
        while(iter != null){
            copy.next = iter.next;
            iter.next = iter.next.next;

            copy = copy.next;
            iter = iter.next;
        } 
        return dummy.next;
    }
}