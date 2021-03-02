package CH4_TreesAndGraphs;

public class CheckBalanced {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9};
        TreeNode root = TreeNode.createMinimalBST(arr);
        root.insertInOrder(3);
        root.insertInOrder(2);
        root.insertInOrder(4);

        int[] result = root.heightAndBalance();
        System.out.print("Height: " + result[0] + "\nBalanced: ");
        if (result[1] == 0) {
            System.out.println("False");
        }
        else if (result[1] == 1) {
            System.out.println("True");
        }
    }
}
