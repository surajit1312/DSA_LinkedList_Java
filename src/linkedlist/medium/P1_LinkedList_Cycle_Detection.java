/**
 * 
 */
package linkedlist.medium;

/**
 * 
 * CodingNinjas: Cycle Detection in a Singly Linked List
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/cycle-detection-in-a-singly-linked-list_628974
 * 
 * TC: O(n)
 * SC: O(1)
 */
public class P1_LinkedList_Cycle_Detection {

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	static class LinkedList {
		Node head;
		int length = 0;

		public void addItem(int data) {
			Node newNode = new Node(data);
			if (head == null) {
				head = newNode;
				return;
			}
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}

		public int size() {
			length = 0;
			Node current = head;
			while (current != null) {
				current = current.next;
				length++;
			}
			return length;
		}

		public Node addItems(int[] list) {
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
			Node current = head;
			while (current != null) {
				System.out.print(current.data + " --> ");
				current = current.next;
			}
			System.out.print("NULL");
		}

		public Node addLoopToIndex(int index) {
			Node current = head;
			Node target = null;
			Node last = null;
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, -1 };
		int loopIndex = 1;
		LinkedList list = new LinkedList();
		list.addItems(nums);
		System.out.println("\nLinkedList :");
		list.print();
		boolean listHasCycle1 = detectCycle(list.head);
		System.out.println("\nAbove Linked List has cycle : " + listHasCycle1);
		
		Node loopedList = list.addLoopToIndex(loopIndex);
		list.head = loopedList;
		boolean listHasCycle2 = detectCycle(loopedList);
		System.out.println("\nAbove Linked List has cycle : " + listHasCycle2);
	}

	private static boolean detectCycle(Node head) {
		if (head == null || head.next == null) {
			return false;
		}
		Node slow = head;
		Node fast = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

}
