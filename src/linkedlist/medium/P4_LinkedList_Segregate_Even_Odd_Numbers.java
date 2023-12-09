/**
 * 
 */
package linkedlist.medium;

/**
 * CodingNinjas: Segregate Even And Odd Nodes In a Linked List
 * 
 * Link:
 * 
 * https://www.codingninjas.com/studio/problems/segregate-even-and-odd-nodes-in-a-linked-list_1116100
 * 
 * TC: O(n)
 * SC: O(1)
 * 
 */
public class P4_LinkedList_Segregate_Even_Odd_Numbers {

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
		int[] nums = { 2, 1, 3, 5, 6, 4, 7, -1 };
		LinkedList list = new LinkedList();
		list.addItems(nums);
		System.out.println("LinkedList :");
		list.print();
		Node evenOddList = segregateEvenOdd(list.head);
		list.head = evenOddList;
		System.out.println("LinkedList after even/odd segregation :");
		list.print();
	}

	private static Node segregateEvenOdd(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node eHead = null, eTail = null, oHead = null, oTail = null;
		Node current = head;
		while (current != null) {
			// Even List
			if (current.data % 2 == 0) {
				if (eHead == null) {
					eHead = current;
					eTail = eHead;
				} else {
					eTail.next = current;
					eTail = eTail.next;
				}
			} else { // Odd List
				if (oHead == null) {
					oHead = current;
					oTail = oHead;
				} else {
					oTail.next = current;
					oTail = oTail.next;
				}
			}
			current = current.next;
		}
		if (eHead == null) {
			return oHead;
		}
		if (oHead == null) {
			return eHead;
		}
		oTail.next = null;
		eTail.next = oHead;
		return eHead;
	}

}
