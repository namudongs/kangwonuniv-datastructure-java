class Heap{
    private int heapSize;
    private int itemHeap[];

    public Heap() {
        heapSize = 0;
        itemHeap = new int[50];
    }

    public void insertHeap(int item) {
        int i = ++heapSize;
        while ((i!=1) && (item > itemHeap[i/2]) ) {
            itemHeap[i] = itemHeap[i/2];
            i /= 2;
        }
        itemHeap[i] = item;
    }

    public int getHeapSize() {
        return this.heapSize;
    }

    public int deleteHeap() {
        int parent, child;
        int item, temp;
        item = itemHeap[1];
//		temp = itemHeap[heapSize--];
        temp = itemHeap[heapSize];
        itemHeap[heapSize--] = item;
        parent = 1; child =2;

        while(child <= heapSize) {
            if((child < heapSize) && (itemHeap[child] < itemHeap[child+1]))
                child++;
            if(temp >= itemHeap[child]) break;

            itemHeap[parent] = itemHeap[child];
            parent = child;
            child *= 2;
        }
        itemHeap[parent] = temp;
        return item;
    }

    public void printHeap(int size) {
        System.out.printf("\nArrary >>>");
        for(int i=1; i<=size; i++ )
            System.out.printf("[%d] ", itemHeap[i], null);
        System.out.printf("\n\n");
    }
}

class HeapSort {

    public static void main(String[] args) {
        int n, item;
        Heap h = new Heap();
        int[] a = {20, 15, 30, 5, 25, 70, 40, 55, 10, 35};

        for(int i=0; i<a.length; i++) h.insertHeap(a[i]);
        int size = h.getHeapSize();
        h.printHeap(size);
        for(int i=0; i<a.length; i++) h.deleteHeap();
        h.printHeap(size);
    }

}

public class Ex9_3 {

    public static void main(String[] args) {
        int n, item;
        Heap h = new Heap();

        h.insertHeap(20);
        h.insertHeap(15);
        h.insertHeap(30);
        h.insertHeap(5);
        h.insertHeap(25);
        h.insertHeap(70);
        h.insertHeap(40);
        h.insertHeap(55);
        h.insertHeap(10);
        h.insertHeap(35);

        h.printHeap(10);

//        for(int i=1; i<=4; i++) {
//            item = h.deleteHeap();
//            System.out.printf("\n deleted Item : [%d]", item, args);
//        }
    }
}
