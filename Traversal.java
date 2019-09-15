public class BinaryTree {
    private static class Node{
        private char val;
        private Node left = null;
        private Node right = null;
        private Node(char val){
            this.val = val;
        }

        @Override
        public String toString() {
            return String.format("{%c}",this.val);
        }
    }

    public static Node buildTree(){
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');
        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;
        e.right = h;

        return a;
    }

    //前序遍历二叉树
    public static void preOrderTraversal(Node root){
        //如何找终止条件，在形参中
        if(root == null){
            return;
        }
        System.out.print(root);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //中序遍历二叉树
    public static void inOrderTraversal(Node root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root);
        inOrderTraversal(root.right);
    }

    //后序遍历二叉树
    public static void postOrderTraversal(Node root){
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root);
    }
    public static void main(String[] args) {
        Node root = buildTree();
        System.out.println("Success");
        System.out.println("前序：");
        preOrderTraversal(root);
        System.out.println();
        System.out.println("中序：");
        inOrderTraversal(root);
        System.out.println();
        System.out.println("后序：");
        postOrderTraversal(root);
    }
}
