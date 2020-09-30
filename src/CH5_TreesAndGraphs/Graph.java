package CH5_TreesAndGraphs;

public class Graph {
    private static final int MAX_VERTICES = 15;
    private GraphNode[] vertices;
    public int verticeCount;

    public Graph() {
        vertices = new GraphNode[MAX_VERTICES];
        verticeCount = 0;
    }

    public void addNode(GraphNode x) {
        if(verticeCount < vertices.length) {
            vertices[verticeCount] = x;
            verticeCount++;
        }
        else {
            System.out.println("Max number of vertices reached");
        }
    }

    public GraphNode[] getVertices() {
        return vertices;
    }
}
