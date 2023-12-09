/**
 * 
 */
package linkedlist.hard;

/**
 * CodingNinjas: Clone a Linked List with random pointers
 * 
 * Link:
 * 
 * https://www.codingninjas.com/studio/problems/clone-a-linked-list-with-random-pointers_983604
 * 
 * TC: O(3n) ~ O(n)
 * SC: O(1)
 * 
 */
public class P1_LinkedList_Clone_With_Random_Pointers {

	static class Node {
		public int data;
		public Node next;
		public Node random;

		Node() {
			this.data = 0;
			this.next = null;
			this.random = null;
		}

		Node(int data) {
			this.data = data;
			this.next = null;
			this.random = null;
		}

		Node(int data, Node next, Node random) {
			this.data = data;
			this.next = next;
			this.random = random;
		}
	}

	static class LinkedList {
		Node head;

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

		public Node addItems(int[] list) {
			for (Integer it : list) {
				if (it != -1)
					addItem(it);
			}
			return head;
		}

		public Node addItemsWithPointers(int[] list, int[] pointers) {
			for (int i = 0; i < list.length; i++) {
				if (list[i] != -1) {
					addItem(list[i]);
				}
			}
			Node current = head;
			int index = 0;
			while (current != null) {
				current.random = getNodeBySearch(pointers[index]);
				current = current.next;
				index++;
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

		public Node getNodeBySearch(int index) {
			if (head == null) {
				return null;
			}
			Node current = head;
			int count = 0;
			while (current != null) {
				if (count == index) {
					return current;
				}
				current = current.next;
				count++;
			}
			return null;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		int[] pointers = { 2, 0, 4, 4, 1 };
		LinkedList list = new LinkedList();
		Node listWithPointers = list.addItemsWithPointers(nums, pointers);
		System.out.println("LinkedList :");
		list.head = listWithPointers;
		list.print();
		Node dupNode = cloneLL(listWithPointers);
		System.out.println("\nCloned LinkedList :");
		list.head = dupNode;
		list.print();
	}

	private static Node cloneLL(Node head) {
		Node chainedNode = formChainedClonedList(head);
		Node randomChainedNode = formRandomPointersNode(chainedNode);
		Node clonedList = retrieveClonedList(randomChainedNode);
		return clonedList;
	}

	private static Node formChainedClonedList(Node head) {
		Node current = head;
		while (current != null) {
			Node temp = current.next;
			current.next = new Node(current.data);
			current.next.next = temp;
			current = temp;
		}
		return head;
	}

	private static Node formRandomPointersNode(Node head) {
		Node current = head;
		while (current != null) {
			if (current.next != null) {
				current.next.random = current.random == null ? null : current.random.next;
			}
			current = current.next.next;
		}
		return head;
	}

	private static Node retrieveClonedList(Node head) {
		Node original = head;
		Node cloned = new Node(0);
		Node temp = cloned;
		Node fast;
		while (original != null) {
			fast = original.next.next;
			temp.next = original.next;
			original.next = fast;
			temp = temp.next;
			original = fast;
		}
		return cloned.next;
	}

}
