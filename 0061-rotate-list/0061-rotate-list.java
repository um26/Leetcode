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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;

        int length=1;
        ListNode temp=head;
        while(temp.next!=null){
            length++;
            temp=temp.next;
        }
        k=k%length;
        if(k==0) return head;

        temp.next=head;

        ListNode curr=head;
        ListNode fast=head;

        for(int i=0;i<length-k-1;i++){
            fast=fast.next;
        }
        curr=fast.next;
        fast.next=null;
        
        return curr;
    }
}