// leetcode.com/onlinejudge
// Given a linked list, remove the nth node from the end of list and return its head.

// For example,

   // Given linked list: 1->2->3->4->5, and n = 2.

   // After removing the second node from the end, the linked list becomes 1->2->3->5.
// Note:
// Given n will always be valid.
// Try to do this in one pass.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==1)
        {
            if (head.next == null)
                return null;
            else
            {
                ListNode ptr = head.next.next;
                ListNode target = head;
                while(ptr!= null)
                {
                    ptr = ptr.next;
                    target = target.next;
                }
                target.next = null;   
            }
        }
        else
        {
            int num = n;
            ListNode ptr=head;
            while( num >0)
            {
                ptr = ptr.next;
                num--;
            }
            ListNode target = head;
            while( ptr!= null)
            {
                ptr = ptr.next;
                target = target.next;
            }

            target.val = target.next.val;
            target.next =target.next.next;
        }
        return head;      
    }
}