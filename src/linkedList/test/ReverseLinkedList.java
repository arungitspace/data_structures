package linkedList.test;



public class ReverseLinkedList {

    //https://leetcode.com/problems/reverse-linked-list/description/

      public static ListNode reverseList(ListNode head) {
            ListNode newHead = null;

            while (head != null){
                  ListNode next = head.next;
                  head.next = newHead;
                  newHead = head;
                  head = next;
            }

            return newHead;
      }

}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }