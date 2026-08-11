import java.util.*;

public class Main {

    static ArrayList<Integer>[] tree;

    // BFS
    static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[tree.length];

        q.add(start);
        visited[start] = true;

        System.out.print("BFS: ");

        while (!q.isEmpty()) {
            int node = q.remove();
            System.out.print(node + " ");

            for (int child : tree[node]) {
                if (!visited[child]) {
                    visited[child] = true;
                    q.add(child);
                }
            }
        }

        System.out.println();
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

        // Step 1: Depth
        System.out.print("Enter depth of tree: ");
        int depth = sc.nextInt();

        // Step 2: No. of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        // Step 3: Elements
        String[] elements = new String[n];

        System.out.println("Enter the elements:");

        for (int i = 1; i < n; i++) {
            elements[i] = sc.next();
        }

        // Create tree
        tree = new ArrayList[n];

        for (int i = 1; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        // Create binary tree automatically
        for (int i = 1; i < n; i++) {

            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < n)
                tree[i].add(left);

            if (right < n)
                tree[i].add(right);
        }

        System.out.println("\nDepth: " + depth);

        // BFS
        System.out.print("BFS: ");
        BFS(1);

        // DFS
        System.out.print("DFS: ");
        boolean[] visited = new boolean[n];
        DFS(1, visited);

        sc.close();
    }
}

