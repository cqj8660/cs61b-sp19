public class LinkedListDeque<T> {

    private TNode senF;
    private TNode senB;
    private int size;
    
    public class TNode {
        public TNode prev;
        public T item;
        public TNode next;
        public TNode(T item) {
            this.item = item;
        }
        public TNode() {
        }
    }
    public LinkedListDeque() {
        senF = new TNode();
        senF.prev = null;
        senB = new TNode();
        senF.next = senB;
        senB.next = null;
     }
     public LinkedListDeque(LinkedListDeque<T> other) {
        senF = new TNode();
        senF.prev = null;
        senB = new TNode();
        senF.next = senB;
        senB.next = null;
        TNode tNode = other.senF.next;
        while(tNode != senF) {
            addLast(tNode.item);
            tNode = tNode.next;
        }
     }

    public int size() {
        return size;
    }
    public void addFirst(T item) {
        TNode tNode = new TNode(item);
        tNode.prev = senF;
        tNode.next = senF.next;
        senF.next.prev = tNode;
        senF.next = tNode;
        size += 1;
    }
    public void addLast(T item) {
        TNode tNode = new TNode(item);
        tNode.prev = senB.prev;
        tNode.next = senB;
        senB.prev.next = tNode;
        senB.prev = tNode;
        size += 1;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public T removeFirst() {
        TNode tNode = senF.next;
        tNode.next.prev = senF;
        senF.next = tNode.next;
        size--;
        return tNode.item;
    }
    public T removeLast() {
        TNode tNode = senB.prev;
        tNode.prev.next = senB;
        senB.prev = tNode.prev;
        size--;
        return tNode.item;
    }
    public T get(int index) {
        TNode tNode = senF.next;
        int idx = 1;
        while(tNode.next != null && idx < index) {
            tNode = tNode.next;
            idx++;
        }
        return tNode.item;
    }
    public void printDeque() {
        TNode tNode = senF.next;
        while(tNode.next != senB) {
            System.out.print(tNode.item);
            tNode = tNode.next;
        }
        System.out.println();
    }
    
}
