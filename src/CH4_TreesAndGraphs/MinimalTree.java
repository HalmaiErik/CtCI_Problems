package CH4_TreesAndGraphs;

// Solution in TreeNode class

public class MinimalTree {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(arr);

        System.out.println("In-order:");
        root.inOrder();
        System.out.println("\n");
    }



}
