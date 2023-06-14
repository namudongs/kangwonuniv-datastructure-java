//public class Ex8_1 {
//
//    public static void main(String[] args) {
//        int queueSize = 5;
//        char deletedItem;
//        ArrayQueue Q = new ArrayQueue(queueSize);
//
//        Q.enQueue('A');
//        Q.printQueue();
//
//        Q.enQueue('B');
//        Q.printQueue();
//
//        deletedItem = Q.deQueue();
//        if(deletedItem != 0)
//            System.out.println("deleted Item : " + deletedItem);
//        Q.printQueue();
//
//        Q.enQueue('C');
//        Q.printQueue();
//
//        deletedItem = Q.deQueue();
//        if(deletedItem != 0)
//            System.out.println("deleted Item : " + deletedItem);
//        Q.printQueue();
//
//        Q.enQueue('D');
//        Q.printQueue();
//
//        deletedItem = Q.deQueue();
//        if(deletedItem != 0)
//            System.out.println("deleted Item : " + deletedItem);
//        Q.printQueue();
//
//        deletedItem = Q.deQueue();
//        if(deletedItem != 0)
//            System.out.println("deleted Item : " + deletedItem);
//        Q.printQueue();
//
//        Q.enQueue('D');
//        Q.enQueue('H');
//        Q.printQueue();
//
//        Q.deQueue();
//        Q.deQueue();
//        Q.printQueue();
////
////		위 프로그램을 큐 아이즈를 5로 변경한 후에 다시 한번 더 실행해 보시오.
////		그리고 이어서 2번의 enQueue 함수와 2번의 deQueue 함수를 차례로 실행해 보시오.
////
//    }
//}
