public class Solution {
    public static Node constructLL(int []arr) {
        // Write your code here
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i = 1; i < arr.length; i++){
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        temp.next = null; // Setting the next of the last node to null
        return head;
    }
}
