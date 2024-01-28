public class Solution {
    public static Node flattenLinkedList(Node head) {
        if(head == null || head.next == null){
            return head;
        }
        // Recur for list on right
        head.next = flattenLinkedList(head.next);

        //Now merge, it will be in turn merged with its left 
        head = mergeLinkedList(head, head.next);

        // Return head
        return head;
    }
    public static Node mergeLinkedList(Node a, Node b){
        Node temp = new Node(0);
        Node res = temp;

        while(a != null && b != null){
            if(a.data < b.data){
                temp.child = a;
                temp = temp.child;
                a = a.child;
            }
            else{
                temp.child = b;
                temp = temp.child;
                b = b.child;
            }
        }
        if(a != null){
            temp.child = a;
        }
        else{
            temp.child = b;
        }
        return res.child;
    }

}
