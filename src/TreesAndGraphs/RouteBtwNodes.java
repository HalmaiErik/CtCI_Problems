package TreesAndGraphs;

import CH4_StackAndQueues.MyQueue;

public class RouteBtwNodes {
    public enum State {
        BLACK, GRAY, WHITE;
    }

    // Use BFS Algorithm
    public static boolean search(Graph g, GraphNode startNode, GraphNode endNode) {
        MyQueue<GraphNode> q = new MyQueue<GraphNode>();
        // Set all vertices to black (= unvisited)
        for(GraphNode n : g.getNodes()) {
            n.state = State.WHITE;
        }

        // Set start node as gray (= visiting)
        startNode.state = State.GRAY;
        q.add(startNode);
        while(!q.isEmpty()) {
            GraphNode r = q.remove();
            if(r != null) {
                // Visit all of the adjacent vertices
                for(GraphNode v : r.getChildren()) {
                    if(v.state == State.WHITE) {
                        if(v == endNode)
                            return true;
                        else {
                            v.state = State.GRAY;
                            q.add(v);
                        }
                    }
                }
                r.state = State.BLACK;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        GraphNode[] temp = new GraphNode[6];

        temp[0] = new GraphNode("a", 3);
        temp[1] = new GraphNode("b", 0);
        temp[2] = new GraphNode("c", 0);
        temp[3] = new GraphNode("d", 1);
        temp[4] = new GraphNode("e", 1);
        temp[5] = new GraphNode("f", 0);

        temp[0].addChild(temp[1]);
        temp[0].addChild(temp[2]);
        temp[0].addChild(temp[3]);
        temp[3].addChild(temp[4]);
        temp[4].addChild(temp[5]);
        for (int i = 0; i < 6; i++) {
            g.addNode(temp[i]);
        }

        GraphNode start1 = temp[3]; GraphNode end1 = temp[5];
        System.out.println(search(g, start1, end1));

        GraphNode start2 = temp[4]; GraphNode end2 = temp[1];
        System.out.println(search(g, start2, end2));
    }
}
