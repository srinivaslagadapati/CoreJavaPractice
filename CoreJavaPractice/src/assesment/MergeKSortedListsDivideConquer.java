package assesment;

class MergeKSortedListsDivideConquer {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeLists(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = mergeLists(lists, left, mid);
        ListNode l2 = mergeLists(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    // Helper function to merge two sorted lists (used in divide & conquer)
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	System.out.println(l1);
    	System.out.println(l2);
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = (l1 != null) ? l1 : l2;
        System.out.println("dummy.next" + dummy.next.val);

        return dummy.next;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        MergeKSortedListsDivideConquer solution = new MergeKSortedListsDivideConquer();

        // Example: lists = [[1,4,5],[1,3,4],[2,6]]
        ListNode[] lists = new ListNode[]{
            new ListNode(1, new ListNode(4, new ListNode(5))),
            new ListNode(1, new ListNode(3, new ListNode(4))),
            new ListNode(2, new ListNode(6))
        };

        ListNode mergedList = solution.mergeKLists(lists);
        printList(mergedList); // Expected Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6 -> null
    }

    // Helper function to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}

