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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null) return null;
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        n=count-n-1;
        if(n==-1) {
            head=head.next;
        }
        else{
            int s=0;
            temp=head;
            while(s<n){
                temp=temp.next;
                s++;
            }
            temp.next=temp.next.next;
            }
        return head;
    }
}