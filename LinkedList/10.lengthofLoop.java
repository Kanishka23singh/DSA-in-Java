public class Solution
{
    public static int lengthOfLoop(Node head) {
        // Write your code here
        Node s = head;
        Node f = head;
        int len = 0;

        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
            if(s == f){
                f = f.next; // We took a extra step here so that we again reach end of cycle;
                len++; 
                while(s != f){
                    f = f.next;
                    len++;
                }
                return len;
            }
        }
        return 0;
    }
}