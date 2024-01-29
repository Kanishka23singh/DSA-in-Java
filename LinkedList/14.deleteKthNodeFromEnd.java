public class Solution
{
    public static Node removeKthNode(Node head, int K)
    {
        
        Node fast = head;
        Node slow = head;   

        for(int i = 0; i < K; i++){
            fast = fast.next;
        }

        if(fast == null){
            return head.next;
        }
    
        while(fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}