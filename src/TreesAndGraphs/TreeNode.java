package TreesAndGraphs;

public class TreeNode {
    private int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    private void setLeftChild(TreeNode left) {
        this.left = left;
        if(left != null)
            left.parent = this;
    }

    private void setRightChild(TreeNode right) {
        this.right = right;
        if(right != null)
            right.parent = this;
    }

    public void insertInOrder(int data) {
        if(this.data <= data) {
            if(left == null)
                setLeftChild(new TreeNode(data));
            else
                left.insertInOrder(data);
        }
        else {
            if(right == null)
                setRightChild(new TreeNode(data));
            else
                right.insertInOrder(data);
        }
    }

    /**
     * Given a sorted array, it's start point and it's end point, creates a BST with minimal height.
     * @param sortedArr The sorted array
     * @param start The starting index
     * @param end The ending index
     * @return The root of the created tree
     */
    private static TreeNode createMinimalBST(int[] sortedArr, int start, int end) {
        if(end < start)
            return null;
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(sortedArr[mid]);
        n.setLeftChild(createMinimalBST(sortedArr, start, mid - 1));
        n.setRightChild(createMinimalBST(sortedArr, mid + 1, end));
        return n;
    }

    // Public version of createMinimalBST
    public static TreeNode createMinimalBST(int[] sortedArr) {
        return createMinimalBST(sortedArr, 0, sortedArr.length - 1);
    }

    public int height() {
        int leftHeight = 0;
        if(left != null)
            leftHeight = left.height();


        int rightHeight = 0;
        if(right != null)
            rightHeight = right.height();

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public void preOrder() {
        System.out.print(data + " ");
        if(left != null)
            left.preOrder();
        if(right != null)
            right.preOrder();
    }


    public void inOrder() {
        if(left != null)
            left.inOrder();
        System.out.print(data + " ");
        if(right != null)
            right.inOrder();

    }

    public void postOrder() {
        if(left != null)
            left.postOrder();
        if(right != null)
            right.postOrder();
        System.out.print(data + " ");
    }

    public int getData() {
        return data;
    }
}
