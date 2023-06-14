import com.sun.source.tree.Tree;

public class Ex9_2 {
    public static void main(String[] args) {
        BinarySearchTree bsT = new BinarySearchTree();
        bsT.insertBST('G');
        bsT.insertBST('I');
        bsT.insertBST('H');
        bsT.insertBST('D');
        bsT.insertBST('B');
        bsT.insertBST('M');
        bsT.insertBST('N');
        bsT.insertBST('A');
        bsT.insertBST('J');
        bsT.insertBST('F');
        bsT.insertBST('E');
        bsT.insertBST('Q');

        System.out.printf("\nBinary Tree >>> ");
        bsT.printBST();

        System.out.printf("Is There \"A\" ? >>>");
        TreeNode p1 = bsT.searchBST('A');
        if (p1 != null)
            System.out.printf("Searching Success! Searched key: %c \n", p1.data);
        else
            System.out.printf("Searching fail!! \n");

        System.out.printf("Is There \"Z\" ? >>>");
        TreeNode p2 = bsT.searchBST('Z');
        if (p2 != null)
            System.out.printf("Searching Success! Searched key: %c \n", p2.data);
        else
            System.out.printf("Searching fail!! \n");

        bsT.deleteBST('G');
        System.out.printf("\nBinary Tree >>> ");
        bsT.printBST();
        System.out.println();

        bsT.deleteBST('M');
        System.out.printf("\nBinary Tree >>> ");
        bsT.printBST();
        System.out.println();

        bsT.deleteBST('D');
        System.out.printf("\nBinary Tree >>> ");
        bsT.printBST();
        System.out.println();
    }
}

class TreeNode {
    char data;
    TreeNode left;
    TreeNode right;
}

class BinarySearchTree {
    private TreeNode root = null;

    public TreeNode insertKey(TreeNode root, char x) {
        TreeNode p = root;
        TreeNode newNode = new TreeNode();
        newNode.data = x;
        newNode.left = null;
        newNode.right = null;
        if (p == null)
            return newNode;
        else if(newNode.data < p.data) {
            p.left = insertKey(p.left, x);
            return p;
        }
        else if(newNode.data > p.data) {
            p.right = insertKey(p.right, x);
            return p;
        }
        else return p;
    }

    public void deleteKey(TreeNode root, char x) {
        TreeNode p = root;
        TreeNode parent = null;
        while (p != null) {        // 삭제할 노드 찾기
            if (x == p.data) break;
            parent = p;
            if (x < p.data) p = p.left;
            else p = p.right;
        }

        if (p == null) return;    //삭제할(x를 갖는) 노드가 BST내에 없음

        System.out.printf("Deleted key = %c \n", p.data);

        // 단말 노드 (자식이 없는 노드) 삭제
        if(p.left == null && p.right == null) {
            if(parent != null) {
                if(parent.left == p)
                    parent.left = null;
                else
                    parent.right = null;
            }
            else root = null;
        }

        // 한 개의 자식을 갖는 노드 삭제
        else if((p.left != null && p.right == null) || (p.left == null && p.right != null)) {
            if(p.left != null) {
                //왼쪽 자식 1개 존재
                if(parent != null) {
                    if(parent.left == p)
                        parent.left = p.left;
                    else
                        parent.right = p.left;
                }
                else root = p.left;
            }
            else {
                // 오른쪽 자식 1개 존재
                if(parent != null) {
                    if(parent.left == p)
                        parent.left = p.right;
                    else
                        parent.right = p.right;
                }
                else root = p.right;
            }
        }


        else {	//2개 자식갖는 노드 삭제
            TreeNode q = maxNode(p.left);
            System.out.printf("maxNode key = %c \n", q.data);
            p.data = q.data;
            if(q == p.left) p.left = q.left;
            else deleteKey(p.left, q.data);
        }


    }

    public TreeNode maxNode(TreeNode t) {
        TreeNode p = t;
        while (p.right != null) p = p.right;
        return p;
    }

    public void insertBST(char x) {
        root = insertKey(root, x);
    }

    public void deleteBST(char x) {
        deleteKey(root, x);
    }

    public TreeNode searchBST(char x) {
        TreeNode p = root;
        while (p != null) {
            if (x < p.data) p = p.left;
            else if (x > p.data) p = p.right;
            else return p;
        }
        System.out.println();
        return p;
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.printf(" %c", root.data);
            inorder(root.right);
        }
    }

    public void printBST() {
        inorder(root);
        System.out.println();

    }
}