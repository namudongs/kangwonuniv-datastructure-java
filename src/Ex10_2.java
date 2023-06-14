//아래에 있는 GraphNode와 AdjList 클래스가 Ex10_1.java에 있는 프로그램과 충돌이 남
// Ex10_1.java에 있는 두 class 정의를 comment 처리해야 함

class StackNode {
    int data;
    StackNode link;
}

class LinkedStack {
    StackNode top;
    int stackSize = 0; //싸이클 찾기 함수를 위해 추가됨

    public boolean isEmpty() {
        return (top == null);
    }

    public void push(int item) {
        StackNode newNode = new StackNode();
        newNode.data = item;
        newNode.link = top;
        top = newNode;
        stackSize++; //싸이클 찾기 함수를 위해 추가됨
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Deleting fail! Linked Stack is empty!!");
            return 0;
        } else {
            int item = top.data;
            top = top.link;
            stackSize--;  //싸이클 찾기 함수를 위해 추가됨
            return item;
        }
    }
}

class QNode {
    int data;
    QNode link;
}

class LinkedQueue {
    QNode front;
    QNode rear;

    public LinkedQueue() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return (front == null);
    }

    public void enQueue(int item) {
        QNode newNode = new QNode();
        newNode.data = item;
        newNode.link = null;
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.link = newNode;
            rear = newNode;
        }
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Deleting fail! Linked Queue is empty!!");
            return 0;
        } else {
            int item = front.data;
            front = front.link;
            if (front == null)
                rear = null;
            return item;
        }
    }
}

class GraphNode {        //Ex10_1.java에 있는 class와 충돌됨. Ex10_1.java에 있는 class 정의를 comment 처리함
    int vertex;
    GraphNode link;
}

class AdjList {        //Ex10_1.java에 있는 class와 충돌됨. Ex10_1.java에 있는 class 정의를 comment 처리함
    GraphNode head[] = new GraphNode[10];
    private int totalV = 0;

    public void insertVertex(int v) {
        totalV++;
    }

    public void insertEdge(int v1, int v2) {
        if (v1 >= totalV || v2 >= totalV)
            System.out.println("그래프에 없는 정점입니다!!");
        else {
            GraphNode gNode = new GraphNode();
            gNode.vertex = v2;
            gNode.link = head[v1];
            head[v1] = gNode;
        }
    }

    public void printAdjList() {
        GraphNode gNode = new GraphNode();
        for (int i = 0; i < totalV; i++) {
            System.out.printf("\n정점%c의 인접리스트 ", i + 65);
            gNode = head[i];
            while (gNode != null) {
                System.out.printf("-> %c", gNode.vertex + 65);
                gNode = gNode.link;
            }
        }
    }

    public void DFS(int v) {
        GraphNode w = new GraphNode();
        LinkedStack S = new LinkedStack();
        boolean visited[] = new boolean[10];
        S.push(v);
        visited[v] = true;
        System.out.printf(" %c", v + 65);
        while (S.top != null) {
            w = head[v];
            while (w != null) {
                if (visited[w.vertex] == false) {
                    S.push(w.vertex);
                    visited[w.vertex] = true;
                    System.out.printf(" %c", w.vertex + 65);
                    v = w.vertex;
                    w = head[v];
                } else w = w.link;
            }
            v = S.pop();
        }
    }


    public void DFSnew(int v) {
        GraphNode w = new GraphNode();
        LinkedStack S = new LinkedStack();
        boolean visited[] = new boolean[10];
        visited[v] = true;
        System.out.printf(" %c", v + 65);
        while (true) {
            w = head[v];
            while (w != null) {
                if (visited[w.vertex] == false) {
                    S.push(v);
                    visited[w.vertex] = true;
                    System.out.printf(" %c", w.vertex + 65);
                    v = w.vertex;
                    w = head[v];
                } else w = w.link;
            }
            if (S.top == null) return;
            else v = S.pop();
        }
    }

    public void findCycle(int v) {
        //
        // 위 DFSnew 함수를 이용하여 싸이클을 찾는 함수를 작성하시오.
        //
    }

//public void BFS(int v) {
//        GraphNode w = new GraphNode();
//        LinkedQueue Q = new LinkedQueue();
//        boolean visited[] = new boolean[10];
//        // 교재 참고하여 코드를 완성하시오
//        System.out.printf(" %c", v + 65, head);
//        // 교재 참고하여 코드를 완성하시오
//        while(   // 교재 참고하여 코드를 완성하시오  ) {
//        // 교재 참고하여 코드를 완성하시오
//        for(   // 교재 참고하여 코드를 완성하시오   ) {
//        if(   // 교재 참고하여 코드를 완성하시오   ) {
//        // 교재 참고하여 코드를 완성하시오
//        System.out.printf(" %c", w.vertex + 65);
//        // 교재 참고하여 코드를 완성하시오
//        }
//        }
//        }
//        }
//        }
}

public class Ex10_2 {
    public static void main(String args[]) {
        AdjList G9 = new AdjList();

        for (int i = 0; i < 7; i++)
            G9.insertVertex(i);

// 교재에 있는 그래프
        G9.insertEdge(0, 2);
        G9.insertEdge(0, 1);
        G9.insertEdge(1, 0);
        G9.insertEdge(1, 4);
        G9.insertEdge(1, 3);

        G9.insertEdge(2, 4);
        G9.insertEdge(2, 0);
        G9.insertEdge(3, 6);
        G9.insertEdge(3, 1);
        G9.insertEdge(4, 6);
        G9.insertEdge(4, 2);
        G9.insertEdge(4, 1);
        G9.insertEdge(5, 6);
        G9.insertEdge(6, 5);
        G9.insertEdge(6, 4);
        G9.insertEdge(6, 3);

// 교재에 없는 새로운그래프
//		G9.insertEdge(0,1);
//		G9.insertEdge(0,2);
//		G9.insertEdge(1,0);
//		G9.insertEdge(2,0);
//		G9.insertEdge(2,4);
//		G9.insertEdge(2,5);
//		G9.insertEdge(3,4);
//		G9.insertEdge(4,2);
//		G9.insertEdge(4,3);
//		G9.insertEdge(4,5);
//		G9.insertEdge(5,2);
//		G9.insertEdge(5,4);
//
        System.out.printf("\n 그래프 G9의 인접리스트 : ");
        G9.printAdjList();
        System.out.println();

        System.out.printf("\n\n 깊이우선탐색 0 >> ");
        G9.DFS(0);

        System.out.printf("\n 깊이우선탐색 1 >> ");
        G9.DFS(1);

        System.out.printf("\n 깊이우선탐색 2 >> ");
        G9.DFS(2);

        System.out.printf("\n 깊이우선탐색 3 >> ");
        G9.DFS(3);

        System.out.printf("\n 깊이우선탐색 4 >> ");
        G9.DFS(4);

        System.out.printf("\n 깊이우선탐색 5 >> ");
        G9.DFS(5);

// DFSnew 함수를 완성한 후에 아래 문장들을 실행하시오.

		System.out.printf("\n\n 새로운 깊이우선탐색 0 >> ");
		G9.DFSnew(0);

		System.out.printf("\n 새로운 깊이우선탐색 1 >> ");
		G9.DFSnew(1);

		System.out.printf("\n 새로운 깊이우선탐색 2 >> ");
		G9.DFSnew(2);

		System.out.printf("\n 새로운 깊이우선탐색 3 >> ");
		G9.DFSnew(3);

		System.out.printf("\n 새로운 깊이우선탐색 4 >> ");
		G9.DFSnew(4);

		System.out.printf("\n 새로운 깊이우선탐색 5 >> ");
		G9.DFSnew(5);


//        System.out.printf("\n\n 너비우선탐색 0 >> ");
//        G9.BFS(0);
//
//        System.out.printf("\n 너비우선탐색 1 >> ");
//        G9.BFS(1);
//
//        System.out.printf("\n 너비우선탐색 2 >> ");
//        G9.BFS(2);
//
//        System.out.printf("\n 너비우선탐색 3 >> ");
//        G9.BFS(3);
//
//        System.out.printf("\n 너비우선탐색 4 >> ");
//        G9.BFS(4);
//
//        System.out.printf("\n 너비우선탐색 5 >> ");
//        G9.BFS(5);

// findCycle 함수를 완성한 후에 아래 문장들을 실행하시오.
//
//		System.out.printf("\n\n Cycle 찾기 0 >> ");
//		G9.findCycle(0);
//
//		System.out.printf("\n Cycle 찾기 1 >> ");
//		G9.findCycle(1);
//
//		System.out.printf("\n Cycle 찾기 2 >> ");
//		G9.findCycle(2);
//
//		System.out.printf("\n Cycle 찾기 3 >> ");
//		G9.findCycle(3);
//
//		System.out.printf("\n Cycle 찾기 4 >> ");
//		G9.findCycle(4);
//
//		System.out.printf("\n Cycle 찾기 5 >> ");
//		G9.findCycle(5);

// findCycleNew 함수를 완성한 후에 아래 문장들을 실행하시오.
//
//		System.out.printf("\n\n Cycle 찾기 0 >> ");
//		G9.findCycleNew(0);
//
//		System.out.printf("\n Cycle 찾기 1 >> ");
//		G9.findCycleNew(1);
//
//		System.out.printf("\n Cycle 찾기 2 >> ");
//		G9.findCycleNew(2);
//
//		System.out.printf("\n Cycle 찾기 3 >> ");
//		G9.findCycleNew(3);
//
//		System.out.printf("\n Cycle 찾기 4 >> ");
//		G9.findCycleNew(4);
//
//		System.out.printf("\n Cycle 찾기 5 >> ");
//		G9.findCycleNew(5);

    }
}