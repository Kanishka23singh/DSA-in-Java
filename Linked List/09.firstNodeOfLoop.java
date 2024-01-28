public class Solution {
    public static Node firstNode(Node head) {
        // Write your code here.
        if(head == null && head.next == null){
            return null;
        }

        Node s = head;
        Node f = head;

        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
            if(s == f){ // There is a cycle

                // Finding node :
                f = head;
                while(s != f){
                    f = f.next;
                    s = s.next;
                }
                return s; 
            }   
        }
        return null;
    }
}
