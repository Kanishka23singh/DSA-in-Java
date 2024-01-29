/*Given a singly linked list of 'N' nodes. The objective is to determine the middle node of a singly linked list. 
However, if the list has an even number of nodes, we return the second middle node. 
Sample Input 1 :
5
1 2 3 4 5
Sample Output 1 :
3 4 5
Explanation Of Sample Input 1 :
We can clearly see that there are 5 elements in the linked list therefore the middle node is the node with value '3'.
Sample Input 2 :
6
1 2 3 4 5 6
Sample Output 2 :
4 5 6
Explanation Of Sample Input 2 :
We can clearly see that there are 6 elements in the linked list and the middle nodes are  nodes with values 3 and 4 
hence we return a second middle node having value '4'.
*/

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
}