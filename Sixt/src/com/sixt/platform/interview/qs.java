package com.sixt.platform.interview;

import java.util.ArrayList;
import java.util.List;

public class qs {
    private final ArrayList<Integer>[] graph;

    qs(ArrayList<Integer>[] graph) {
        this.graph = graph;
    }

    boolean hasCycle(ArrayList<Integer>[] graph) {
        List<Integer> visited = new ArrayList<>();
        for (int i = 0; i < graph.length; ++i) {
            if (hasCycle(i, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycle(int node, List<Integer> visited) {
        if (visited.contains(node)) {
            return true;
        }
        visited.add(node);
        for (Integer nextNode : graph[node]) {
            if (hasCycle(nextNode, visited)) {
                return true;
            }
        }
        visited.remove(visited.size() - 1);
        return false;
    }
}