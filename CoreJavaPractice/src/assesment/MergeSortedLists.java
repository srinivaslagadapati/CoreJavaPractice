package assesment;
class ListNode {
    int val;
    ListNode next;
    
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeSortedLists {
    
    // Recursive Approach
    public static ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoListsRecursive(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursive(list1, list2.next);
            return list2;
        }
    }

    // Iterative Approach
    public static ListNode mergeTwoListsIterative(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);  // Dummy node
        ListNode current = dummy;
        while (list1 != null && list2 != null) {
        	System.out.println("list1:" +list1.val);
            System.out.println("list2:" +list2.val);
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            System.out.println("current:" +current.next.val);
            current = current.next;
        }

        // Attach the remaining nodes
        if (list1 != null) current.next = list1;
        if (list2 != null) current.next = list2;
        System.out.println("dummy:" +dummy.next);
        return dummy.next;
    }

    // Helper method to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Main method for testing
    public static void main(String[] args) {
        // Creating two sorted linked lists: 1 -> 3 -> 5 and 2 -> 4 -> 6
        ListNode list1 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode list2 = new ListNode(2, new ListNode(4, new ListNode(6)));
        System.out.println("list1:" +list1.val);
        System.out.println("list2:" +list2.val);
        System.out.println("Merging using Recursive approach:");
        ListNode mergedRecursive = mergeTwoListsRecursive(list1, list2);
        printList(mergedRecursive);

        // Resetting lists for iterative approach
        list1 = new ListNode(1, new ListNode(3, new ListNode(5)));
        list2 = new ListNode(2, new ListNode(4, new ListNode(6)));

        System.out.println("Merging using Iterative approach:");
        ListNode mergedIterative = mergeTwoListsIterative(list1, list2);
        printList(mergedIterative);
    }
}
