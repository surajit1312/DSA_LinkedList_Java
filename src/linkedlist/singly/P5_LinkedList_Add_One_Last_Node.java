/**
 * 
 */
package linkedlist.singly;

/**
 * 
 * CodingNinjas: Add One to Linked List
 * 
 * Link:
 * https://www.codingninjas.com/studio/problems/add-one-to-linked-list_920456
 * 
 * TC: O(n)
 * SC: O(n)
 * 
 */
public class P5_LinkedList_Add_One_Last_Node {

	static class LinkedListNode {
		int data;
		LinkedListNode next;

		public LinkedListNode(int data) {
			this.data = data;
			this.next = null;
		}

		public LinkedListNode(int data, LinkedListNode next) {
			this.data = data;
			this.next = next;
		}
	}

	static class LinkedList {
		LinkedListNode head;
		int length = 0;

		public void addItem(int data) {
			LinkedListNode newNode = new LinkedListNode(data);
			if (head == null) {
				head = newNode;
				return;
			}
			LinkedListNode current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}

		public int size() {
			length = 0;
			LinkedListNode current = head;
			while (current != null) {
				current = current.next;
				length++;
			}
			return length;
		}

		public LinkedListNode addItems(int[] list) {
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
			LinkedListNode current = head;
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
		int[] nums = { 9, 9, 9, 9, -1 };
		LinkedList list = new LinkedList();
		list.addItems(nums);
		System.out.println("LinkedList before modification :");
		list.print();
		LinkedListNode newList = addOneToList(list.head);
		list.head = newList;
		System.out.println("\nLinkedList after modification :");
		list.print();
	}

	private static LinkedListNode addOneToList(LinkedListNode linkedListNode) {
		if (linkedListNode == null) {
			linkedListNode = new LinkedListNode(1);
			return linkedListNode;
		}
		int carry = 1;
		carry = addOneToListHelper(linkedListNode, carry);
		if (carry > 0) {
			LinkedListNode newHead = new LinkedListNode(carry);
			newHead.next = linkedListNode;
			return newHead;
		} else {
			return linkedListNode;
		}
	}

	private static int addOneToListHelper(LinkedListNode node, int carry) {
		if (node == null) {
			return 1;
		}
		carry = addOneToListHelper(node.next, carry);
		int data = node.data + carry;
		if (data >= 10) {
			node.data = data - 10;
			carry = 1;
		} else {
			node.data = data;
			carry = 0;
		}
		return carry;
	}

}
