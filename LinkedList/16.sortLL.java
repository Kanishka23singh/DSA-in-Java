/* Time Complexity : O(logn)*O(n+n/2) = O(nlogn)
   Space Complexity : O(1)
*/
public class Solution {
    public static Node sortList(Node head) {
        
    if (head == null || head.next == null) {
        return head;
    }

    // Split Linked List in two halves
    Node middle = getMiddle(head);
    Node newHead = middle.next;
    middle.next = null;

    // Recursively sort two halves
    Node left = sortList(head);
    Node right = sortList(newHead);

    // Merge the two sorted halves and return
    return merge(left, right);
}
    // Find Middle
    public static Node getMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    // Merge two linkedList
    public static Node merge(Node l1, Node l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        Node dummy = new Node(0);
        Node curr = dummy;

        while(l1 != null && l2 != null){
            if(l1.data < l2.data){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 != null){
            curr.next = l1;
        }
        if(l2 != null){
            curr.next = l2;
        }
        return dummy.next;
    }
}

/*
Time Complexity : O(n)+O(nlogn)+O(n) = O(nlogn)
Space Complexity : O(n) (extra space)
import java.util.*;
public class Solution {
    public static Node sortList(Node head) {
        //Write your code here
        if(head == null || head.next == null){
            return head;
        }

        Node temp = head;
        ArrayList<Integer> list = new ArrayList<>();
        while(temp != null){
            list.add(temp.data);
            temp = temp.next;
        }
        Collections.sort(list);

        int i = 0;
        temp = head;
        while(temp != null){
            temp.data = list.get(i);
            temp = temp.next;
            i++;
        }
        return head;
    }
}
*/