/**
 * 
 */
package linkedlist.singly;

/**
 * 
 * CodingNinjas: Introduction To Linked List
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/introduction-to-linked-list_8144737
 * 
 * TC: O(n)
 * SC: O(1)
 * 
 */
public class P1_LinkedList_Introduction {

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
				addItem(it);
			}
			return head;
		}

		public int searchItem(int data) {
			if (head == null) {
				return -1;
			}
			Node current = head;
			int index = 0;
			while (current != null) {
				if (current.data == data) {
					return index;
				}
				current = current.next;
				index++;
			}
			return -1;
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
		int[] nums = { 1, 2, 3, 4, 5 };
		LinkedList list = new LinkedList();
		list.addItems(nums);
		list.print();
		System.out.println("\nLength of the LinkedList : " + list.size());
	}

}
