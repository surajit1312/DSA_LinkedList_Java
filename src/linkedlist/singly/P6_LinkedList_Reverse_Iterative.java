/**
 * 
 */
package linkedlist.singly;

/**
 * GeeksForGeeks: Reverse a linked list
 * 
 * Link: https://www.geeksforgeeks.org/problems/reverse-a-linked-list/1
 * 
 * TC: O(n)
 * SC: O(1)
 * 
 */
public class P6_LinkedList_Reverse_Iterative {

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
		LinkedList revList = new LinkedList();
		revList.head = reverseList(list.head);
		System.out.println("\nReverse LinkedList :");
		revList.print();
	}

	private static Node reverseList(Node head) {
		Node prev = null;
		Node current = head;
		while (current != null) {
			Node temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		return prev;
	}

}
