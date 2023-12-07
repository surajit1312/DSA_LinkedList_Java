/**
 * 
 */
package linkedlist.singly;

/**
 * 
 * CodingNinjas: Insert Node At The Beginning
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/insert-node-at-the-beginning_8144739
 * 
 * TC: O(n)
 * SC: O(1)
 * 
 */
public class P4_LinkedList_Insert_Node_At_Beginning {

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
		int[] nums = { 4, 2, 5, 1 };
		LinkedList list = new LinkedList();
		list.addItems(nums);
		System.out.println("LinkedList before insertion :");
		list.print();
		int newValue = 0;
		Node listnew = insertAtFirst(list.head, newValue);
		list.head = listnew;
		System.out.println("\nLinkedList after insertion :");
		list.print();
	}

	public static Node insertAtFirst(Node list, int newValue) {
		Node newHead = new Node(newValue);
		if (list == null) {
			list = newHead;
			return newHead;
		}
		newHead.next = list;
		return newHead;
	}

}
