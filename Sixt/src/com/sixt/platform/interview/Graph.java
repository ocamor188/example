package com.sixt.platform.interview;

import java.util.*;

public class Graph {

    private final int V;
    private final List<List<Integer>> adjencyListCyclic;
    private LinkedList<Integer> adjListForTopoSort[]; // Adjacency List


    public Graph(int V) {
        this.V = V;
        adjencyListCyclic = new ArrayList<>(V);
        adjListForTopoSort = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjListForTopoSort[i] = new LinkedList();
            adjencyListCyclic.add(new LinkedList<>());

        }
    }

    private boolean isCyclicUtil(int i, boolean[] visited,
                                 boolean[] recStack) {

        // Mark the current node as visited and
        // part of recursion stack
        if (recStack[i]) {
            return true;
        }

        if (visited[i]){return false;}

        visited[i] = true;

        recStack[i] = true;
        List<Integer> children = adjencyListCyclic.get(i);

        for (Integer c : children) {
            if (isCyclicUtil(c, visited, recStack)) {
                return true;
            }
        }
        recStack[i] = false;

        return false;
    }

    // Function to add an edge into the graph
    void addEdge(int v,int w) {
        adjencyListCyclic.get(v).add(w);
        adjListForTopoSort[v].add(w); }

    // Returns true if the graph contains a
    // cycle, else false.
    private boolean isCyclic() {

        // Mark all the vertices as not visited and
        // not part of recursion stack
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        // Call the recursive helper function to
        // detect cycle in different DFS trees
        for (int i = 0; i < V; i++) {
            if (isCyclicUtil(i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    // A recursive function used by topologicalSort
    void topologicalSortUtil(int v, boolean visited[],
                             Stack stack) {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> it = adjListForTopoSort[v].iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        // Push current vertex to stack which stores result
        stack.push(new Integer(v));
    }

    // The function to do Topological Sort. It uses
    // recursive topologicalSortUtil()
    void topologicalSort() {
        Stack stack = new Stack();

        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++){ visited[i] = false;}

        // Call the recursive helper function to store
        // Topological Sort starting from all vertices
        // one by one
        for (int i = 0; i < V; i++) {
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);
        }
        int index = stack.size();
        // Print contents of stack
        while (stack.empty() == false) {
            System.out.println("Executed: " + "[" + index-- + "] --> " + stack.pop() + " ");
        }
    }


    // Driver code
    public static void main(String[] args) {
        Graph graph = new Graph(7);

        final VulnerabilityScript script1 = new VulnerabilityScript(1, Collections.singletonList(6));
        final VulnerabilityScript script2 = new VulnerabilityScript(2, Collections.singletonList(1));
        final VulnerabilityScript script3 = new VulnerabilityScript(3, Arrays.asList(1, 5));
        final VulnerabilityScript script4 = new VulnerabilityScript(4, Arrays.asList(1, 2));
        final VulnerabilityScript script5 = new VulnerabilityScript(5, Arrays.asList(2, 4));
        final VulnerabilityScript script6 = new VulnerabilityScript(6, new ArrayList<>());
        List<VulnerabilityScript> vulnerabilityScripts = new ArrayList<>();
        vulnerabilityScripts.add(script1);
        vulnerabilityScripts.add(script2);
        vulnerabilityScripts.add(script3);
        vulnerabilityScripts.add(script4);
        vulnerabilityScripts.add(script5);
        vulnerabilityScripts.add(script6);

        for (VulnerabilityScript vulnerabilityScript : vulnerabilityScripts) {
            for (Integer dependency : vulnerabilityScript.getDependencies()) {
                graph.addEdge(vulnerabilityScript.getScriptId(), dependency);
            }
        }

        if (graph.isCyclic()) {
            throw new RuntimeException("Graph is cyclic");
        } else {
            graph.topologicalSort();
        }
    }
}
