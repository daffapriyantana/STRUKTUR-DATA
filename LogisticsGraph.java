import java.util.*;

public class LogisticsGraph {
    private int vertices;
    private LinkedList<Integer>[] adjList;

    public LogisticsGraph(int v) {
        vertices = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adjList[i] = new LinkedList<>();
    }

    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }

    public void printAdjacencyMatrix() {
        int[][] matrix = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int dest : adjList[i]) {
                matrix[i][dest] = 1;
            }
        }
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    public void BFS(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        System.out.print("BFS traversal: ");
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print((char)('A' + node) + " ");
            for (int neighbor : adjList[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void DFSUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print((char)('A' + node) + " ");
        for (int neighbor : adjList[node]) {
            if (!visited[neighbor])
                DFSUtil(neighbor, visited);
        }
    }

    public void DFS(int start) {
        boolean[] visited = new boolean[vertices];
        System.out.print("DFS traversal: ");
        DFSUtil(start, visited);
        System.out.println();
    }

    public static void main(String[] args) {
        LogisticsGraph g = new LogisticsGraph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(4, 0);

        g.printAdjacencyMatrix();
        g.BFS(0);
        g.DFS(0);
    }
}
