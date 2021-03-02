package CH4_TreesAndGraphs;

public class Successor {
    public static void main(String[] args) {
        int[] arr2 = {3, 5, 7, 10, 15, 20, 30};
        TreeNode root2 = TreeNode.createMinimalBST(arr2);
        root2.inOrder();
        System.out.println();

        System.out.println(root2.findSuccessor());      // Successor of 10
        TreeNode iter = root2;
        iter = iter.left.left;
        System.out.println(iter.findSuccessor());       // Successor of 3
        iter = iter.parent.right;
        System.out.println(iter.findSuccessor());       // Successor of 7

        //TreeNode
    }
}
