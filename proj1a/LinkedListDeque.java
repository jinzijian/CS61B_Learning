public class LinkedListDeque<T> {
    private  class StuffNode {
        public T item;
        public StuffNode next;
        public StuffNode prev;


        public StuffNode(T i, StuffNode p,StuffNode n) {
            item = i;
            next = n;
            prev = p;
        }
    }
    private StuffNode sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new StuffNode(null,null ,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        /**构建双向循环链表的哨兵结点*/
        size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T x) {
        sentinel.next = new StuffNode(x,sentinel,sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        /**prev需要被修改，next直接沿用就好*/
        size += 1;
    }
    public void addLast(T x) {
        sentinel.prev.prev.next = sentinel.prev;
        sentinel.prev = new StuffNode(x,sentinel.prev.prev,sentinel.prev.next);/**头结点连接到新的last*/
        /**把之前的尾结点和新的last链接*/
        size += 1;
    }
    public T removeFirst() {
        T removed = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        if (!isEmpty()) {
            size -= 1;
        }
        return removed;
    }
    /**
     * Print the items in the deque from first to last, separated by a space
     * Once all the items have been printed, print out a new line
     */
    public void printDeque(){
        int i = 0;
        StuffNode printed = sentinel.next;
        while(i<size){
            System.out.println(printed.item+" ");
            printed = printed.next;
            i+=1;
        }
        System.out.println();
    }
    public T removeLast(){
        if (size == 0){
            return null;
        }
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        return sentinel.prev.item;
    }
    public T get(int index){
        if(size<index){
            return null;
        }
        int i = 0;
        StuffNode geted = sentinel.next;
        while(i<index){
            geted = geted.next;
            i+=1;
        }
        return geted.item;
    }
    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new StuffNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;

        for (int i = 0; i < other.size(); i++) {
            addLast((T) other.get(i)); // (T) is cast, since type of other is unknown
        }
    }
    private T getRecursive(int index, StuffNode curr){
        if (size<index){
            return null;
        }
        if (index == 0){
            return curr.item;
        }
        return getRecursive(index - 1, curr.next);

        }
    }
    public T getRecursive(int index){
        if (size<index){
            return null;
        }
        if (index == 0){
            return sentinel.next.item;
        }
        if ( index < size() || size>0){
            this.removeFirst();
            return this.getRecursive(index -1);
        }
    }
}

