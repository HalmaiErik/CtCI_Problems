package TreesAndGraphs;

public class GraphNode {
    private String name;
    private GraphNode[] children;
    private int childrenCount;
    public RouteBtwNodes.State state;

    public GraphNode(String name, int childrenCount) {
        this.name = name;
        this.childrenCount = 0;
        this.children = new GraphNode[childrenCount];
    }

    public void addChild(GraphNode x) {
        if(childrenCount < children.length) {
            this.children[childrenCount] = x;
            childrenCount++;
        }
        else {
            System.out.println("Adjacency list full");
        }
    }

    public GraphNode[] getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }
}
