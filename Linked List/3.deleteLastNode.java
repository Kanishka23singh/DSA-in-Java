public class Solution {
    public static Node deleteLast(Node list){
        // Write your code here
        Node temp = list;
        int size = size(list);
        for(int i = 0; i < size - 2; i++){
            temp = temp.next;
        }
        temp.next = null;
        return list;
    }
    public static int size(Node head){
        Node temp = head;
        int size = 0;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        return size;
    }
}