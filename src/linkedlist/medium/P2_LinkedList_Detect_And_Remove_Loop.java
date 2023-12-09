/**
 * 
 */
package linkedlist.medium;

/**
 * 
 * CodingNinjas: Detect and Remove Loop
 * 
 * Link:
 * 
 * https://www.codingninjas.com/studio/problems/interview-shuriken-42-detect-and-remove-loop_241049
 * 
 * TC: O(n)
 * SC: O(1)
 * 
 */
public class P2_LinkedList_Detect_And_Remove_Loop {

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
		int[] nums = { 452, 225, 671, 76, 911, 748, 403, 646, 272, 586, 481, 389, 345, 841, 325, 563, 452, 46, 540, 821,
				924, 568, 121, 924, 100, 795, 181, 324, 384, 229, 142, 177, 795, 675, 260, 472, 804, 720, 1, 858, 401,
				445, 193, 999, 542, 35, 318, 390, 794, 506, 514, 388, 521, 38, 900, 728, 840, 301, 368, 289, 464, 172,
				11, 527, 672, 402, 868, 985, 292, 863, 356, 688, 396 };
		int loopIndex = 1;
		LinkedList list = new LinkedList();
		list.addItems(nums);
		System.out.println("LinkedList :");
		list.print();

		Node loopedList = list.addLoopToIndex(loopIndex);
		list.head = loopedList;
		boolean listHasCycle1 = detectCycle(loopedList);
		System.out.println("\nAbove Linked List has cycle : " + listHasCycle1);

		Node removedLoopList = removeLoop(loopedList);
		list.head = removedLoopList;
		boolean listHasCycle2 = detectCycle(removedLoopList);
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

	private static Node removeLoop(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node slow = head;
		Node fast = head;
		Node meet = null;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				meet = slow;
				break;
			}
		}
		Node loopStart = getLoopStart(head, meet);
		if (loopStart != null) {
			loopStart.next = null;
		}
		return head;
	}

	private static Node getLoopStart(Node start, Node meet) {
		if (meet == null) {
			return null;
		}
		Node loopStart = null;
		while (start != meet) {
			loopStart = meet;
			start = start.next;
			meet = meet.next;
		}
		return loopStart;
	}

}
