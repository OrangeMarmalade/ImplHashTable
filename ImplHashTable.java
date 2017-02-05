class Node {
	public Node next;
	int data;
	public Node(int x) {
		data = x;
		next = null;
	}
	
}
public class ImplHashTable {
	private Node[] table;
	private int size;
	public ImplHashTable (int inputSize) {
		size = 0;
		table = new Node [inputSize];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		table = new Node[table.length];
		size = 0;
	}
	public void insert(int input) {
		size++;
		int position = hashing(input);
		Node pointer = new Node(input);
		if (table[position] == null) {
			table[position] = pointer;
		} else {
			pointer.next = table[position];
			table[position] = pointer;
		}
	}
	public boolean remove(int input) {
		int position = hashing(input);
		Node start = table[position];
		Node end = start;
		if (start.data == input) {
			size--;
			table[position] = start.next;
			return true;
		}
		while (end.next != null && end.next.data != input) {
			end = end.next;
		}
		if (end.next == null) {
			System.out.println("No items to be removed!");
			return false;
		} else {
			size--;
			if (end.next.next == null) {
				end.next = null;
				
			}
			end.next = end.next.next;
			table[position] = start;
			return true;
		}
	}
	public boolean contains(int input) {
		return false;
	}
	
	public int hashing(Integer input) {
		int hashed = input.hashCode();
		hashed = hashed % table.length;
		if (hashed < 0) {
			hashed += table.length;
		}
		return hashed;
	}
	

}
