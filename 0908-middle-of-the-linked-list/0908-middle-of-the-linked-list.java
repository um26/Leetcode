/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        // int count=0;
        // ListNode temp=head;
        // while(temp.next !=null){
        //     temp.next=temp;
        //     count++;
        // }
        
        // while()

        ListNode slow=head, fast= head;
        while(fast !=null && fast.next != null){
            slow=slow.next;
            fast= fast.next.next;
        }
        return slow;
    }
}