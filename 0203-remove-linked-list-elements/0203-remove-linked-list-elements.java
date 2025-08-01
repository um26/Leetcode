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
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;
        ListNode prev=new ListNode(0);
        ListNode curr=head;
        prev.next=head;
        while(head!=null && head.val==val) head=head.next;
        while(curr!=null){
            if(curr.val==val){
                prev.next=curr.next;
                curr=curr.next;
            }
            else{
                prev=curr;
                curr=curr.next;
            }
        }
        return head;
    }
}