public class ArrayDeque<T> {

    private T[] array;
    private int size; 
    private int head; //下一个前端待插入的位置
    private int tail; //下一个尾端待插入的位置

    public static void testAddLast() {
        ArrayDeque<Integer> target = new ArrayDeque<>();

        target.addLast(1);
        target.addLast(4);
        target.addLast(7);
        target.addLast(14);
        target.addLast(24);
        target.addLast(56);
        target.addLast(24);
        target.addLast(56);

        int r1 = target.get(0);
		target.addFirst(100);
		// target.removeFirst(100);
		// target.removeFirst(100);
		// target.removeFirst(100);
		// target.removeFirst(100);
		// target.removeLast(100);
		// target.removeLast(100);

        target.printDeque();
    }

    public static void testAddFirst() {
        ArrayDeque<Integer> target = new ArrayDeque<>();
        target.addFirst(3);
        target.addFirst(5);
        target.addFirst(11);
        target.addFirst(4);
        target.addFirst(7);
        target.addFirst(14);
        target.addFirst(24);
        target.addFirst(56);
        target.printDeque();

    }

    public static void testResizeNull() {
        ArrayDeque<Integer> target = new ArrayDeque<>();
        target.addFirst(3);
        target.addFirst(5);
        target.addFirst(11);
        target.addFirst(4);
        target.addFirst(7);
        target.addFirst(14);
        target.addFirst(24);
        target.addFirst(56);
        target.addFirst(6);
        int r1 = target.removeFirst();
        int r2 = target.removeLast();
        target.printDeque();

    }
    public ArrayDeque() {
        array = (T[]) new Object[8];
        size = 0;
        head = 7;
        tail = 0;
    }

    // public ArrayDeque(ArrayDeque<T> other) {
    //     size = other.size;
    //     head = other.head;
    //     tail = other.tail;
    //     array = (T[]) new Object[8];
    //     for(int i = 0; i < 8; i++)
    //     {
    //         array[i] = other.array[i];
    //     }
    // }

    private void resizing() {
        T[] resizedArray = (T[])new Object[array.length << 1];
        int oriLength = array.length;
        //填充前半部分
        System.arraycopy(array, 0, resizedArray, 0, head + 1);  
        if(head + 1 != array.length) {
            //填充后半部分
            System.arraycopy(array, head + 1, resizedArray, oriLength + head + 1, oriLength - tail - 1);
        }
        array = resizedArray;
        head = head + oriLength; //head向前移动至正确的位置

    }

    public int size() {
        return size;
    }

    public void addFirst(T item) {
        size++;
        array[head] = item;
        head = head - 1 >= 0 ? head - 1 : array.length - 1;
        if (head == tail) {
            resizing();
        }

    }

    public void addLast(T item) {
        size++;
        array[tail] = item;
        tail = (tail + 1) % array.length;
        if (head == tail) {
            resizing();
        }

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T removeFirst() {
        if(isEmpty()) {
            System.out.println("Deque is empty");
            return null;
        }   
        head = (head + 1) % array.length;
        size--;
        T ret = array[head];
        array[head] = null;
        return ret;
    }

    public T removeLast() {
        if(isEmpty()) {
            System.out.println("Deque is empty");
            return null;
        }
        tail = tail - 1 >= 0 ? tail - 1 : array.length - 1;
        size--;
        T ret = array[tail];
        array[tail] = null;
        return ret;
    }

    public T get(int index) {
        int idx = (head + index + 1) % array.length;
        return array[idx];
    }

    public void printDeque() {
        int start = (head + 1) % array.length;
        int times = size;
        for(int i = 0; i < times; i++) {
            System.out.print(array[start] + " ");
            start = (start + 1) % array.length;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> aDeque = new ArrayDeque<>();
        // aDeque.addFirst(10);
        // aDeque.addFirst(20);
        // aDeque.addFirst(15);
        // aDeque.addLast(-1);
        // aDeque.printDeque();
        testResizeNull();


    }
}
