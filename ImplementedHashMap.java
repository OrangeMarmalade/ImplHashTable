package source;

public class ImplementedHashMap<X,Y> {
	
	private class Entry<X,Y> {
		public X key;
		public Y value;
		public Entry<X,Y> next;
		public Entry(X k, Y v) {
			key = k;
			value = v;
			next = null;
		}
		public X getKey() {
			return key;
		}
		public Y getValue() {
			return value;
		}
	}
	
	public Entry<X,Y>[] table;
	
	public ImplementedHashMap(int size) {
		table = new Entry[size];
		
	}
	private int hash(X key) {
		return Math.abs(key.hashCode() % table.length);
	}
	public Y get(X key) {
		int index = hash(key);
		Entry<X,Y> curr = table[index];
		while (curr != null) {
			if (curr.getKey().equals(key)) {
				return curr.getValue();
			}
			curr = curr.next;
		}
		return null;
	}
	public Y remove(X key) {
		int index = hash(key);
		Entry<X,Y> curr = table[index];
		if (curr == null) {
			return null;
		}
		if (curr.getKey().equals(key)) {
			Y temp = curr.getValue();
			table[index] = curr.next;
			return temp;
		}
		while (curr.next != null) {
			if (curr.next.getKey().equals(key)) {
				Y temp = curr.next.getValue();
				curr.next = curr.next.next;
				return temp;
			} else {
				curr = curr.next;
			}
		}
		return null;
	}
	public void put(X key, Y value) {
		int index = hash(key);
		Entry<X,Y> curr = table[index];
		if (curr == null) {
			table[index] = new Entry<X,Y>(key, value);
		} else {
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = new Entry<X,Y>(key,value);
		}
	}

}
