package CH4_TreesAndGraphs;

public class CheckBalanced {
    public static void main(String[] args) {
        int[] arr = {4, 6, 7, 8, 10, 11, 12, 14, 15, 16};
        TreeNode root = TreeNode.createMinimalBST(arr);
       // root.insertInOrder(3);
       // root.insertInOrder(2);
       // root.insertInOrder(4);

        System.out.print(root.height());
    }
}
