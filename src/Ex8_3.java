//public class Ex8_3 {
//
//    public static void main(String[] args) {
//        char deletedItem;
//        LinkedQueue LQ = new LinkedQueue();
//
//        LQ.enQueue('A');
//        LQ.printQueue();
//
//        LQ.enQueue('B');
//        LQ.printQueue();
//
//        deletedItem = LQ.deQueue();
//        if(deletedItem != 0)
//            System.out.println("deleted Item : " + deletedItem);
//        LQ.printQueue();
//
//        LQ.enQueue('C');
//        LQ.enQueue('D');
//        LQ.enQueue('E');
//
//        LQ.printQueue();
//
//        LQ.enQueue('F');
//        LQ.enQueue('G');
//        LQ.enQueue('H');
//        LQ.enQueue('I');
//        LQ.enQueue('J');
//
//        LQ.printQueue();
//
//        deletedItem = LQ.deQueue();
//        if(deletedItem != 0)
//            System.out.println("deleted Item : " + deletedItem);
//        LQ.printQueue();
//
//        LQ.enQueue('D');
//        LQ.enQueue('A');
//        LQ.enQueue('T');
//        LQ.enQueue('A');
//        LQ.enQueue('S');
//        LQ.enQueue('T');
//        LQ.enQueue('R');
//        LQ.enQueue('U');
//        LQ.enQueue('C');
//        LQ.enQueue('T');
//        LQ.printQueue();
////
////		이어서 10번의 enQueue 후에 한번의 printQueue를 실행하여, 연결큐는 데이터를 많이 저장하더라도
////		필요한 공간을 할당받아서 계속 큐에 많은 데이터를 저장할 수 있음을 확인하시오.
////
////		위 실습내용의 결과 화면을 캡처하여 실습 과제물로 제출하시오.
////
//    }
//
//}
