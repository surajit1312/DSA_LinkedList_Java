/**
 * 
 */
package linkedlist.medium;

/**
 * CodingNinjas: Delete Middle Node
 * 
 * Link:
 * 
 * https://www.codingninjas.com/studio/problems/delete-middle-node_763267
 * 
 * TC: O(n)
 * SC: O(1)
 * 
 */
public class P3_LinkedList_Delete_Middle_Element {

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
			System.out.println("");
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
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, -1 };
		LinkedList list = new LinkedList();
		list.addItems(nums);
		System.out.println("LinkedList :");
		list.print();
		Node deletedMiddle = deleteMiddle(list.head);
		list.head = deletedMiddle;
		System.out.println("LinkedList after deleting middle element :");
		list.print();
	}

	private static Node deleteMiddle(Node head) {
		if (head == null || head.next == null) {
			return null;
		}
		Node slow = head, fast = head;
		Node prev = null;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = slow.next;
		return head;
	}
}
