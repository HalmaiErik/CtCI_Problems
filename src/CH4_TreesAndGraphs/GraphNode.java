package CH4_TreesAndGraphs;

public class GraphNode {
    private static final int maxChildrenCount = 15;

    private String name;
    private GraphNode[] children;
    private int childrenCount;
    public RouteBtwNodes.State state;

    public GraphNode(String name) {
        this.name = name;
        this.childrenCount = 0;
        this.children = new GraphNode[maxChildrenCount];
        this.state = RouteBtwNodes.State.WHITE;
    }

    public void addChild(GraphNode x) {
        if(childrenCount < maxChildrenCount) {
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
