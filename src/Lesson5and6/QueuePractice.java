package Lesson5and6;

import java.util.HashSet;

public class QueuePractice {

    class Solution237 {
        public class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
         }
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    class Solution206 {
        public class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
        }
        public ListNode reverseList(ListNode head) {
            ListNode current = head;
            ListNode previous = null;
            while (current != null) {
                ListNode temp = current.next;
                current.next = previous;
                previous = current;
                current = temp;
            }
            return previous;
        }
    }

    public class Solution141 {
        class ListNode {
            int val;
            ListNode next;
            ListNode(int x) {
                val = x;
                next = null;
            }
        }
        public boolean hasCycle(ListNode head) {
            HashSet<ListNode> nums = new HashSet<>();
            while (head != null) {
                if (nums.contains(head))
                    return true;
                else {
                    nums.add(head);
                }
                head = head.next;
            }
            return false;
        }
    }

}
