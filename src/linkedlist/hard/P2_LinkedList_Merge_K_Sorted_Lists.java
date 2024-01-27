package linkedlist.hard;

import java.util.PriorityQueue;

/**
 * Leetcode: 23. Merge k Sorted Lists
 * 
 * Link: https://leetcode.com/problems/merge-k-sorted-lists/description/
 * 
 * TC: O(K x log(K) + N x K x log(K))
 * SC: O(K)
 * 
 * Note: TC of any operation on Priority
 * Queue takes log(K) where K is the number of elements in Priority Queue
 * 
 */
public class P2_LinkedList_Merge_K_Sorted_Lists {
    public static void main(String[] args) {
        int[] nums1 = { 1, 4, 5, -1 };
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        list1.addItems(nums1);
        list1.print();

        int[] nums2 = { 1, 3, 4, -1 };
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list2.addItems(nums2);
        list2.print();

        int[] nums3 = { 2, 6, -1 };
        LinkedList<Integer> list3 = new LinkedList<Integer>();
        list3.addItems(nums3);
        list3.print();

        ListNode[] lists = new ListNode[3];
        lists[0] = list1.head;
        lists[1] = list2.head;
        lists[2] = list3.head;

        ListNode mergedNode = mergeKLists(lists);
        LinkedList<Integer> mergedList = new LinkedList<Integer>();
        mergedList.head = mergedNode;
        mergedList.print();
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> (x.value - y.value));
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(new Pair(list.val, list));
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (!pq.isEmpty()) {
            Pair currentPair = pq.poll();
            ListNode node = currentPair.node;
            if (node.next != null) {
                pq.offer(new Pair(node.next.val, node.next));
            }
            temp.next = currentPair.node;
            temp = temp.next;
        }
        return dummy.next;
    }

    static class Pair {
        Integer value;
        ListNode node;

        public Pair(Integer value, ListNode node) {
            this.value = value;
            this.node = node;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

    static class LinkedList<T> {
        ListNode head;
        int length = 0;

        public void addItem(int data) {
            ListNode newNode = new ListNode(data);
            if (head == null) {
                head = newNode;
                return;
            }
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        public int size() {
            length = 0;
            ListNode current = head;
            while (current != null) {
                current = current.next;
                length++;
            }
            return length;
        }

        public ListNode addItems(int[] list) {
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
            ListNode current = head;
            while (current != null) {
                System.out.print(current.val + " --> ");
                current = current.next;
            }
            System.out.print("NULL");
            System.out.println("");
        }

        public ListNode addLoopToIndex(int index) {
            ListNode current = head;
            ListNode target = null;
            ListNode last = null;
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

}
