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
	public LinkedListDeque() {
		sentinelF = new StuffNode( null, null, null);
		sentinelL = new StuffNode( null, null, null);
		sentinelF.next = sentinelL;
		sentinelL.prev = sentinelF;
		size = 0;
	}
	public LinkedListDeque(T item) {
		sentinelF = new StuffNode( null, null, null);
		sentinelL = new StuffNode(null, null, null);
		sentinelF.next = new StuffNode(item, sentinelF, sentinelL);
		sentinelL.prev = sentinelF.next;
		size = 1;
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
		StuffNode toRemove = sentinelF.next;
		StuffNode tmp = sentinelF.next.next;
		sentinelF.next = tmp;
		tmp.prev = sentinelF;
		size -= 1;
		return toRemove.item;
	}
	public T removeLast() {
		StuffNode toRemove = sentinelL.prev;
		StuffNode tmp = sentinelL.prev.prev;
		tmp.next = sentinelL;
		sentinelL.prev = tmp;
		size -= 1;
		return toRemove.item;
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



	private T getRecursive(int index, StuffNode p) {
		if (index == 0) {
			return p.item;
		} else {
			return getRecursive(index - 1, p.next);
		}
	}

	public T getRecursive(int index) {
		if (index > size || index < 0) {
			return null;
		}
		return getRecursive(index, sentinelF.next);
	}


 }