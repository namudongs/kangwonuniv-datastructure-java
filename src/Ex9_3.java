class Heap {
    private int heapSize;
    private int itemHeap[];

    public Heap() {
        heapSize = 0;
        itemHeap = new int[50];
    }

    public void insertHeap(int item) {
        int i = ++heapSize;
        while ((i != 1) && (item > itemHeap[i/2])) {
            itemHeap[i] = itemHeap[i/2];
            i /= 2;
        }
        itemHeap[i] = item;
        System.out.printf("\n inserted Item : [%d]", item);
}

    public int getHeapSize() {
        return this.heapSize;
    }

    public int deleteHeap() {
        int parent, child;
        int item, temp;
        item = itemHeap[1];
        temp = itemHeap[heapSize--];
        parent = 1; child = 2;

        while(child <= heapSize) {
            if ((child < heapSize) && (itemHeap[child] < itemHeap[child+1]))
            child++;
            if (temp >= itemHeap[child]) { break; }
            itemHeap[parent] = itemHeap[child];
            parent = child;
            child *= 2;
        }
        itemHeap[parent] = temp;
        return item;
    }

    public void printHeap() {
        System.out.printf("\nHeap >>> ");
        for(int i=1; i<= heapSize; i++)
            System.out.printf("[%d] ", itemHeap[i], null);
    }

}


public class Ex9_3 {

    public static void main(String[] args) {
        int n, item;
        Heap h = new Heap();

        h.insertHeap(20);
        h.insertHeap(15);
        h.insertHeap(19);
        h.insertHeap(8);
        h.insertHeap(13);
        h.insertHeap(10);

        h.printHeap();

        h.insertHeap(25);
        h.insertHeap(12);
        h.insertHeap(18);
        h.insertHeap(30);

        h.printHeap();

        for(int i=1; i<=4; i++) {
            item = h.deleteHeap();
            System.out.printf("\n deleted Item : [%d]", item, args);
        }

        h.printHeap();
    }
}
