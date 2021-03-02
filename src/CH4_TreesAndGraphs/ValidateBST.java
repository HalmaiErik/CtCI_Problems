package CH4_TreesAndGraphs;

public class ValidateBST {
    public static void main(String[] args) {
        int[] arr1 = {5, 1, 8, 2, 10};
        TreeNode root1 = TreeNode.createMinimalBST(arr1);
        System.out.println(root1.validateBST());

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root2 = TreeNode.createMinimalBST(arr2);
        System.out.println(root2.validateBST());

    }
}
