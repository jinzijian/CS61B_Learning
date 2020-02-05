public class LinkedListDeque<T> {
	private StuffNode sentinelF;
	private StuffNode sentinelL;
	private int size;
	
	private class StuffNode {
		public StuffNode prev;
		public T item;
		public StuffNode next;

		public StuffNode(T i, StuffNode m, StuffNode n){
			item = i;
			prev = m;
			next = n;
		}

	}
	public T LinkedListDeque() {
		sentinelF = new StuffNode( -1, null, sentinelL);
		sentinelL = new StuffNode( -1, sentinelF, null);
		size = 0;
	}
	public void addFirst (T item) {
		StuffNode tmp = sentinelF.next;
		sentinelF.next = new StuffNode( item, sentinelF, tmp);
		tmp.prev = sentinelF.next;
		size += 1;
	}
	public void addLast(T item) {
		StuffNode tmp = sentinelL.prev;
		tmp.next = new StuffNode( item, tmp, sentinelL);
		size += 1;
	}
	public boolean isEmpty() {
		if ( size!= 0 ){
			return true;
		}else{
			return false;
		}
	}
	public int size() {
		return size;
	}
	public void printDeque() {
		StuffNode cur = sentinelF.next;
		for (int i = 0; i < size; i++) {
			System.out.print(cur.item + " ");
			cur = cur.next;
		}
		System.out.println();

	}
	public T removeFirst() {
		StuffNode tmp = sentinelF.next.next;
		sentinelF.next = tmp;
		tmp.prev = sentinelF;
		size -= 1;

	}
	public T removeLast() {
		StuffNode tmp = sentinelL.prev.prev;
		tmp.next = sentinelL;
		sentinelL.prev = tmp;
		size -= 1;
	}
	public T get(int index) {
		StuffNode tmp = sentinelF.next;
		int i = 0;
		if(index > size-1 ){
			return null;
		}
		while(i < index) {
			tmp = tmp.next;
			i += 1;
		}
		return tmp.item;
	}
	public LinkedListDeque(LinkedListDeque other) {
		sentinelF = new StuffNode( -1, null, sentinelL);
		sentinelL = new StuffNode( -1, sentinelF, null);
		size = 0;
		for (int i = 0; i < other.size(); i++) {
			addLast(other.get(i));
	}
}