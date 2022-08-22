// A Java Program to detect cycle in a graph

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
<div class="brinza-task-description">
<p>You are given a directed graph consisting of N vertices, numbered from 1 to N, and N edges.</p>
<p>The graph is described by two arrays, A and B, both of length N. A pair A[K], B[K] (for K from 0 to N-1) describes a directed edge from vertex A[K] to vertex B[K]. Note that the graph might contain self-loops (edges where A[K] = B[K]) and/or multiple edges between the same pair of vertices.</p>
<p>Your task is to check whether the given graph is a cycle. A graph is a cycle if it is possible to start at some vertex and, by following the provided edges, visit all the other vertices and return to the starting point.</p>
<p>For example, A = [1, 3, 2, 4] and B = [4, 1, 3, 2] is a cycle of length 4.</p>
<p><img class="inline-description-image" src="https://codility-frontend-prod.s3.amazonaws.com/media/task_static/is_cycle/static/images/auto/17e0cfba64bcb0785b9a2c8946263c58.png" alt="Example of a graph that is a cycle"></p>
<p>On the other hand, A = [1, 2, 3, 4] and B = [2, 1, 4, 3] is not a cycle. The graph consist of two disjoint cycles of length 2 each.</p>
<p><img class="inline-description-image" src="https://codility-frontend-prod.s3.amazonaws.com/media/task_static/is_cycle/static/images/auto/cc679dc870a40fdf1645b3089fc02c49.png" alt="Example of a graph that is not a cycle"></p>
<p>Write a function:</p>
<blockquote><p style="font-family: monospace; font-size: 9pt; display: block; white-space: pre-wrap"><tt>class Solution { public boolean solution(int[] A, int[] B); }</tt></p></blockquote>
<p>that, given two arrays A and B of N integers each, describing a directed graph, returns <tt style="white-space:pre-wrap">true</tt> if the graph is a cycle and <tt style="white-space:pre-wrap">false</tt> otherwise.</p>
<p><b>Examples:</b></p>
<p>1. Given A = [3, 1, 2] and B = [2, 3, 1], your function should return <tt style="white-space:pre-wrap">true</tt>.</p>
<p><img class="inline-description-image" src="https://codility-frontend-prod.s3.amazonaws.com/media/task_static/is_cycle/static/images/auto/b1c5bc2e147edf3b9bef6483ce1a146f.png" alt="First example test"></p>
<p>2. Given A = [1, 2, 1] and B = [2, 3, 3], your function should return <tt style="white-space:pre-wrap">false</tt>.</p>
<p><img class="inline-description-image" src="https://codility-frontend-prod.s3.amazonaws.com/media/task_static/is_cycle/static/images/auto/aa6cd68e6045bac111e56cfb64a289a6.png" alt="Second example test"></p>
<p>3. Given A = [1, 2, 3, 4] and B = [2, 1, 4, 4], your function should return <tt style="white-space:pre-wrap">false</tt>.</p>
<p><img class="inline-description-image" src="https://codility-frontend-prod.s3.amazonaws.com/media/task_static/is_cycle/static/images/auto/952b83715b85ebf982d62e9cb1b7fe64.png" alt="Third example test"></p>
<p>4. Given A = [1, 2, 3, 4] and B = [2, 1, 4, 3], your function should return <tt style="white-space:pre-wrap">false</tt>.</p>
<p><img class="inline-description-image" src="https://codility-frontend-prod.s3.amazonaws.com/media/task_static/is_cycle/static/images/auto/cc679dc870a40fdf1645b3089fc02c49.png" alt="Fourth example test"></p>
<p>5. Given A = [1, 2, 2, 3, 3] and B = [2, 3, 3, 4, 5], your function should return <tt style="white-space:pre-wrap">false</tt>.</p>
<p><img class="inline-description-image" src="https://codility-frontend-prod.s3.amazonaws.com/media/task_static/is_cycle/static/images/auto/9df28da926b9281f334f73860e50dd07.png" alt="Fifth example test"></p>
<p>Write an <b><b>efficient</b></b> algorithm for the following assumptions:</p>
<blockquote><ul style="margin: 10px;padding: 0px;"><li>N is an integer within the range [<span class="number">1</span>..<span class="number">100,000</span>];</li>
<li>each element of arrays A, B is an integer within the range [1..N];</li>
<li>arrays A and B are of equal length N.</li>
</ul>
</blockquote></div>
class Graph {

    private final int V;
    private final List<List<Integer>> adj;

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new LinkedList<>());
    }

    // Driver code
    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if (graph.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't " + "contain cycle");
    }

    // This function is a variation of DFSUytil() in
    // https:// www.geeksforgeeks.org/archives/18212
    private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {

        // Mark the current node as visited and
        // part of recursion stack
        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;

        recStack[i] = true;
        List<Integer> children = adj.get(i);
        if (i == children.get(adj.size())) return false;

        for (Integer c : children)
            if (isCyclicUtil(c, visited, recStack))
                return true;

        recStack[i] = false;

        return false;
    }

    private void addEdge(int source, int dest) {
        adj.get(source).add(dest);
    }

    // Returns true if the graph contains a
    // cycle, else false.
    // This function is a variation of DFS() in
    // https:// www.geeksforgeeks.org/archives/18212
    private boolean isCyclic() {

        // Mark all the vertices as not visited and
        // not part of recursion stack
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        // Call the recursive helper function to
        // detect cycle in different DFS trees
        for (int i = 0; i < V; i++)
            if (isCyclicUtil(i, visited, recStack))
                return true;

        return false;
    }
}
