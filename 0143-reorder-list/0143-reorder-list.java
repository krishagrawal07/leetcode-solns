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
    private ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;

        while(curr!=null){
            ListNode next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if (head==null || head.next==null) return;

        ListNode slow = head;
        ListNode fast=head;

        while(fast.next!=null && fast.next.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode secondhalf = slow.next;
        slow.next= null;

        ListNode p2=reverse(secondhalf);
        ListNode p1=head;

        while(p1!=null && p2!=null){
            ListNode temp1=p1.next;
            ListNode temp2=p2.next;

            p1.next =p2;
            p2.next=temp1;

            p1=temp1;
            p2=temp2;
        }
    }
}