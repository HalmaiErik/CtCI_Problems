package CH5_TreesAndGraphs;

import java.util.Stack;

public class BuildOrder {
    private static boolean dfs(GraphNode startNode, Stack<GraphNode> stack) {
        if (startNode != null) {
            if (startNode.state == RouteBtwNodes.State.WHITE) {
                startNode.state = RouteBtwNodes.State.GRAY;
                for (GraphNode child : startNode.getChildren()) {
                    if (!dfs(child, stack)) {
                        return false;
                    }
                }
                startNode.state = RouteBtwNodes.State.BLACK;
                stack.push(startNode);
            } else if (startNode.state == RouteBtwNodes.State.GRAY) {
                return false;       // Cycle
            }
        }
        return true;
    }

    private static Stack<GraphNode> order(Graph graph) {
        Stack<GraphNode> stack = new Stack<>();
        for (GraphNode node : graph.getVertices()) {
            if (node != null) {
                if (node.state == RouteBtwNodes.State.WHITE) {
                    if (!dfs(node, stack)) {
                        return null;
                    }
                }
            }
        }
        return stack;
    }

    public static void main(String[] args) {
        GraphNode a = new GraphNode("a");
        GraphNode b = new GraphNode("b");
        GraphNode c = new GraphNode("c");
        GraphNode d = new GraphNode("d");
        GraphNode e = new GraphNode("e");
        GraphNode f = new GraphNode("f");

        a.addChild(d);
        f.addChild(b);
        b.addChild(d);
        f.addChild(a);
        d.addChild(c);

        Graph graph = new Graph();
        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(d);
        graph.addNode(e);
        graph.addNode(f);

        Stack<GraphNode> result = order(graph);
        if (result != null) {
            while (!result.empty()) {
                GraphNode node = result.pop();
                System.out.print(node.getName() + " ");
            }
        }
        else System.out.println("Cycle detected");
    }
}
