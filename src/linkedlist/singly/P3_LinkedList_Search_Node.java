/**
 * 
 */
package linkedlist.singly;

/**
 * 
 * CodingNinjas: Search in a Linked List
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/search-in-a-linked-list_975381
 * 
 * TC: O(n)
 * SC: O(1)
 * 
 */
public class P3_LinkedList_Search_Node {

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
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 3, 6, 2, 7, 9, -1 };
		LinkedList list = new LinkedList();
		list.addItems(nums);
		System.out.println("LinkedList :");
		list.print();
		int k = 2;
		int index = searchInLinkedList(list.head, k);
		System.out.println("\nIndex of " + k + " in LinkedList : " + index);
	}

	public static int searchInLinkedList(Node head, int k) {
		if (head == null) {
			return 0;
		}
		Node current = head;
		int index = 0;
		while (current != null) {
			if (current.data == k) {
				return index;
			}
			current = current.next;
			index++;
		}
		return 0;
	}

}
