# BinaryTree

//题目来源：LeetCode
//105题、106题
//105、从前序与中序遍历序列构造二叉树
//106、从中序与后序遍历序列构造二叉树

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){        //判断树是否为空
            return null;
        }
        int rootValue = preorder[0];     //根结点就是前序遍历preorder的第一个元素
        int LeftCount;                   
        for(LeftCount = 0; LeftCount < inorder.length; LeftCount++){
            if(inorder[LeftCount] == rootValue){//在中序遍历inorder中找到根结点
                break;
            }
        }
        TreeNode root = new TreeNode(rootValue);     //将根结点的值装入结点
        //将preorder中的元素从preorder[1]到preorder[1 + LeftCount](左开右闭，不包括后者)拷贝到新的数组leftPreorder中
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + LeftCount);
        //将inorder中的元素从inorder[0]到inorder[LeftCount]拷贝到leftInorder中
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, LeftCount);
        //递归
        root.left = buildTree(leftPreorder,leftInorder);
        //同理，写出右子树的过程
        int[] rightPreorder = Arrays.copyOfRange(preorder, LeftCount + 1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, LeftCount + 1, inorder.length);
        root.right = buildTree(rightPreorder,rightInorder);
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0){
            return null;
        } 
        int rootValue = postorder[postorder.length - 1];
        int LeftCount;
        for(LeftCount = 0; LeftCount < inorder.length; LeftCount++){
            if(inorder[LeftCount] == rootValue){
                break;
            }
        }
        TreeNode root = new TreeNode(rootValue);
        //这里注意Arrays.copyOfRange()方法拷贝时的范围是：左闭右开
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, LeftCount);
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, LeftCount);
        root.left = buildTree(leftInorder, leftPostorder);
        int[] rightInorder = Arrays.copyOfRange(inorder, LeftCount + 1, postorder.length);
        int[] rightPostorder = Arrays.copyOfRange(postorder, LeftCount, postorder.length - 1);
        root.right = buildTree(rightInorder, rightPostorder);
        return root;
    }
}
