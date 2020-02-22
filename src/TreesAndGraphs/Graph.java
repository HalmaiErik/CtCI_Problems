package TreesAndGraphs;

public class Graph {
    private static final int MAX_VERTICES = 6;
    private GraphNode[] nodes;
    public int count;

    public Graph() {
        nodes = new GraphNode[MAX_VERTICES];
        count = 0;
    }

    public void addNode(GraphNode x) {
        if(count < nodes.length) {
            nodes[count] = x;
            count++;
        }
        else {
            System.out.println("Max number of vertices reached");
        }
    }

    public GraphNode[] getNodes() {
        return nodes;
    }
}
