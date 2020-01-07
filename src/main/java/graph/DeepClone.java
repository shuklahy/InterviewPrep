package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeepClone {

    Map<Node, Node> visited = new HashMap<>();
    /**
     * Return thr clone graph for this node
     *
     * @param node node which need
     * @return
     */
    public Node cloneGraph(Node node) {
        if (this.visited.containsKey(node))
            return this.visited.get(node);
        // Mark as visited

        Node clonedNode = new Node(node.val, null);
        this.visited.put(node, clonedNode);

        List<Node> clonedNeighbours = new ArrayList<>();
        node.neighbors.forEach(n -> {
            Node newNode = cloneGraph(n);
            clonedNeighbours.add(newNode);
        });
        clonedNode.neighbors = clonedNeighbours;
        return clonedNode;
    }


}
