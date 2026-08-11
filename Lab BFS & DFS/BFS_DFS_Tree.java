import java.util.*;

public class BFS_DFS_Tree {

    static ArrayList<Integer>[] tree;

    // BFS
    static void BFS(int start) {
        boolean[] visited = new boolean[tree.length];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        System.out.print("BFS: ");

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int child : tree[node]) {
                if (!visited[child]) {
                    visited[child] = true;
                    queue.add(child);
                }
            }
        }
    }

    // DFS
    static void DFS(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int child : tree[node]) {
            if (!visited[child]) {
                DFS(child, visited);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        tree = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        System.out.println("Enter " + (n - 1) + " edges:");

        for (int i = 1; i <= n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            tree[u].add(v);
            tree[v].add(u);
        }

        int start = 1;

        System.out.println("Starting node: " + start);

        BFS(start);

        System.out.println();

        boolean[] visited = new boolean[n + 1];

        System.out.print("DFS: ");
        DFS(start, visited);

        sc.close();
    }
}