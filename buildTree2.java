# BinaryTree
TreeNode buildTree3(List<Integer> preorder, List<Integer> inorder) {
        if (preorder.isEmpty()) {
            return null;
        }
        int rootValue = preorder.get(0);
        int leftCount = inorder.indexOf(rootValue);
        List<Integer> leftPre = preorder.subList(1, 1 + leftCount);
        List<Integer> leftIn = inorder.subList(0, leftCount);
        List<Integer> rightPre = preorder.subList(1 + leftCount, preorder.size());
        List<Integer> rightIn = inorder.subList(1 + leftCount, preorder.size());
        TreeNode root = new TreeNode(rootValue);
        root.left = buildTree3(leftPre, leftIn);
        root.right = buildTree3(rightPre, rightIn);
        return root;
}

TreeNode buildTree4(int[] preorder, int preFrom, int preTo, int[] inorder, int inFrom, int inTo) {
    return null;
}

// Build Tree Return Value
private static class BTRV {
    private TreeNode root;
    private int used;
}


    BTRV buildTree5(List<Integer> preorder) {
        BTRV returnValue = new BTRV();
        if (preorder.size() == 0) {
            returnValue.root = null;
            returnValue.used = 0;
            return returnValue;
        }
        int rootValue = preorder.get(0);
        if (rootValue == '#') {
            returnValue.root = null;
            returnValue.used = 1;
            return returnValue;
        }
        BTRV leftReturn = buildTree5(preorder.subList(1, preorder.size()));
        BTRV rightReturn = buildTree5(preorder.subList(1 + leftReturn.used,
                preorder.size()));
        TreeNode root = new TreeNode(rootValue);
        root.left = leftReturn.root;
        root.right = rightReturn.root;
        returnValue.root = root;
        returnValue.used = 1 + leftReturn.used + rightReturn.used;
        return returnValue;
    }
