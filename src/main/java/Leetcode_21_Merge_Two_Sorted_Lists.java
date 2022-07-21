package src.main.java;

public class Leetcode_21_Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = list1.val < list2.val ? list1 : list2;
        ListNode result = node;

        if (node.val == list1.val) {
            list1 = list1.next;
        } else {
            list2 = list2.next;
        }

        while (list1 != null || list2 !=null) {
            if (list1 == null) {
                node.next = list2;
                node = node.next;
                list2 = list2.next;
                continue;
            }

            if (list2 == null) {
                node.next = list1;
                node = node.next;
                list1 = list1.next;
                continue;
            }

            if (list1.val <= list2.val) {
                node.next = list1;
                node = node.next;
                list1 = list1.next;
                continue;
            }

            if (list1.val > list2.val) {
                node.next = list2;
                node = node.next;
                list2 = list2.next;
                continue;
            }
        }

        return result;
    }

    public static class ListNode {
      public int val;
      public ListNode next;
      public ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode mergeTwoLists_Optimised(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(0);
        ListNode ans=h;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                h.next = l1;
                h = h.next;
                l1 = l1.next;
            } else {
                h.next = l2;
                h = h.next;
                l2 = l2.next;
            }
        }
        if(l1==null){
            h.next=l2;
        }
        if(l2==null){
            h.next=l1;
        }
        return ans.next;
    }
}
