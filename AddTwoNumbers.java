// leetcode.com/onlinejudge
// You are given two linked lists representing two non-negative numbers. 
// The digits are stored in reverse order and each of their nodes contain a single digit. 
// Add the two numbers and return it as a linked list.

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        int count =0;
        int sum = l1.val + l2.val;
        count = sum/10;
        l1 = l1.next;
        l2 = l2.next;
        ListNode root = new ListNode(sum%10);
        ListNode tmp = root;
        while(l1!= null && l2!= null)
        {
            sum = l1.val + l2.val +count;
            count = sum/10;
            tmp.next = new ListNode(sum%10);
            tmp = tmp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null)
        {
            sum = l1.val + count;
            count = sum/10;
            tmp.next = new ListNode(sum%10);
            tmp = tmp.next;
            l1 = l1.next;
        }
        while(l2 != null)
        {
            sum = l2.val + count;
            count = sum/10;
            tmp.next = new ListNode(sum%10);
            tmp = tmp.next;
            l2 = l2.next;
        }
        if ( count ==1)
            tmp.next = new ListNode(count);
        return root;
    }
}