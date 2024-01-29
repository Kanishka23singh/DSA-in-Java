public class Solution {
    public static int length(Node head){
        //Your code goes here
        int size = 0;
        while(head != null){
            head = head.next;
            size++;
        }
        return size;
    }
}