package linkedList.problem;


class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
       return  val+" : "+next ;
    }
}
public class MergeSorted {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(12);
        l1 = l1.next;
        l1.next = new ListNode(13);
        System.out.println(l1);
    }
}
