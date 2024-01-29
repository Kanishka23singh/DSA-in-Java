public class Solution {

    public static boolean detectCycle(Node head) {
        
        if (head == null || head.next == null) {
            // If the list is empty or has only one node, there can't be a cycle.
            return false;
        }

        Node s = head;
        Node f = head;

        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
            if(s == f)
            return true;
        }
        return false;
    }
}