public class Solution {
    static Node left = null;
    public static boolean isPalindrome(Node head) {
        left = head;
        return isPalindromeHelper(head);
    }

    public static boolean isPalindromeHelper(Node right) {
        if(right == null){
            return true;
        }
        
        boolean rres = isPalindromeHelper(right.next); // recursion result
        if(rres == false){ // *
            return false;
        }
        else if(right.data != left.data){
            return false;
        }
        else{
            left = left.next;
            return true;
        }
    }

}
