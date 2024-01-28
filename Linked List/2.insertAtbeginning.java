public class Solution
{
    public static Node insertAtFirst(Node head, int newValue) {
        // Write your code here
        Node temp = new Node();
        
        temp.data = newValue;
        temp.next = head;
        head = temp;
        
        return head;
    }
}

/*
public class Solution
{
    public static Node insertAtFirst(Node list, int newValue) {
        // Write your code here
        Node temp = new Node;
        if(list == null){
            temp.data = newValue;
            temp.next = null;
            return temp;
        }
        else{
            temp.data = newValue;
            temp.next = list;
            list = temp;
        }
        return list;
    }
}
*/