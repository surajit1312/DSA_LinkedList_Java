package linkedlist.medium;

/**
 * 
 * CodingNinjas: Merge Two Sorted Linked Lists
 * 
 * Link: https://www.codingninjas.com/studio/problems/merge-two-sorted-linked-lists_800332
 * 
 * TC: O(N1 + N2)
 * SC: O(1)
 * 
 */
public class P5_LinkedList_Merge_Two_Sorted_Lists {

    static class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

    static class LinkedList<T> {
        LinkedListNode<Integer> head;
        int length = 0;

        public void addItem(int data) {
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
            if (head == null) {
                head = newNode;
                return;
            }
            LinkedListNode<Integer> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        public int size() {
            length = 0;
            LinkedListNode<Integer> current = head;
            while (current != null) {
                current = current.next;
                length++;
            }
            return length;
        }

        public LinkedListNode<Integer> addItems(int[] list) {
            for (Integer it : list) {
                if (it != -1)
                    addItem(it);
            }
            return head;
        }

        public void print() {
            if (head == null) {
                System.out.println("NULL");
                return;
            }
            LinkedListNode<Integer> current = head;
            while (current != null) {
                System.out.print(current.data + " --> ");
                current = current.next;
            }
            System.out.print("NULL");
            System.out.println("");
        }

        public LinkedListNode<Integer> addLoopToIndex(int index) {
            LinkedListNode<Integer> current = head;
            LinkedListNode<Integer> target = null;
            LinkedListNode<Integer> last = null;
            int count = 0;
            while (current.next != null) {
                if (count == index) {
                    target = current;
                }
                current = current.next;
                count++;
            }
            last = current;
            last.next = target;
            return head;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 5, 7, 8, -1 };
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        list1.addItems(nums1);
        list1.print();

        int[] nums2 = { 1, 3, 4, 6, -1 };
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list2.addItems(nums2);
        list2.print();

        LinkedListNode<Integer> mergedListNode = sortTwoLists(list1.head, list2.head);
        LinkedList<Integer> mergedList = new LinkedList<Integer>();
        mergedList.head = mergedListNode;
        mergedList.print();
    }

    private static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
        LinkedListNode<Integer> dummy = new LinkedListNode<Integer>(-1);
        LinkedListNode<Integer> temp = dummy;
        LinkedListNode<Integer> t1 = first;
        LinkedListNode<Integer> t2 = second;
        while (t1 != null && t2 != null) {
            if (t1.data < t2.data) {
                temp.next = t1;
                temp = t1;
                t1 = t1.next;
            } else {
                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }
        }
        if (t1 != null) {
            temp.next = t1;
        }
        if (t2 != null) {
            temp.next = t2;
        }
        return dummy.next;
    }
}
