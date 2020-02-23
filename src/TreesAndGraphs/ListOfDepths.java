package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths {
    public static ArrayList<LinkedList<TreeNode>> listsOfDepths = new ArrayList<LinkedList<TreeNode>>();

    public static void createListsOfDepths(TreeNode root, int level) {
        if(root == null)
            return;
        LinkedList<TreeNode> l = null;
        if(listsOfDepths.size() == level) {
            // Level not contained in the list (levels are transfered in order)
            l = new LinkedList<TreeNode>();
            listsOfDepths.add(l);
        }
        else {
            l = listsOfDepths.get(level);
        }
        l.add(root);
        createListsOfDepths(root.left, level + 1);
        createListsOfDepths(root.right, level + 1);
    }

    public static void printLists(TreeNode root) {
        createListsOfDepths(root, 0);
        for (LinkedList<TreeNode> list : listsOfDepths) {
            System.out.print(listsOfDepths.indexOf(list) + 1 + ". list: ");
            for(TreeNode n : list) {
                System.out.print(n.getData() + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = TreeNode.createMinimalBST(arr);

        System.out.println("Height: " + root.height());

        System.out.println("Pre-order:");
        root.preOrder();
        System.out.println("\n");

        System.out.println("In-order:");
        root.inOrder();
        System.out.println("\n");

        System.out.println("Post-order:");
        root.postOrder();
        System.out.println("\n\n");

        printLists(root);
    }
}
