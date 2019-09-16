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
    private static int count = 0;

    //遍历思想求结点个数
    public static void getSize(Node root){
        if(root == null){
            return;
        }
        count++;
        getSize(root.left);
        getSize(root.right);
    }

    //汇总思想求结点个数（跟后序遍历二叉树的过程相似）
    public static int getSize2(Node root){
        if(root == null){
            return 0;
        }
        int left = getSize2(root.left);
        int right = getSize2(root.right);
        return left + right + 1;
    }

    //用汇总的思想写前序、中序、后序遍历
    //（力扣：二叉树的前中后序遍历面试题）

    //求叶子结点的个数
    private static int leafSize = 0;
    public static void getLeafSize(Node root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            leafSize++;
        }
        getLeafSize(root.left);
        getLeafSize(root.right);
    }
    //用汇总的思想求叶子结点的个数
    public static int getLeafSize2(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }

        int left = getLeafSize2(root.left);
        int right = getLeafSize2(root.right);
        return left + right;
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
