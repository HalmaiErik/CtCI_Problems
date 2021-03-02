package CH4_TreesAndGraphs;

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

    public int[] heightAndBalance() {
        int leftHeight = 0;
        if(left != null)
            leftHeight = left.heightAndBalance()[0];


        int rightHeight = 0;
        if(right != null)
            rightHeight = right.heightAndBalance()[0];

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return new int[] {1 + Math.max(leftHeight, rightHeight), 0};
        }
        else {
            return new int[] {1 + Math.max(leftHeight, rightHeight), 1};
        }
    }

    public boolean validateBST() {
        if (left != null) {
            if (data < left.getData()) {
                return false;
            }
            else left.validateBST();
        }

        if (right != null) {
            if (data > right.getData()) {
                return false;
            }
            else right.validateBST();
        }

        return true;
    }

    public int findSuccessor() {
        if (right != null) {
            return right.getData();
        }
        else {
            TreeNode iter = this;
            while (iter.parent.right == iter) {
                iter = iter.parent;
            }
            return iter.parent.getData();
        }
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
