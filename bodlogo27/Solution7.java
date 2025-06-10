import java.io.*;
import java.util.*;

public class Solution7 {
    static List<List<Integer>> adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int p = Integer.parseInt(firstLine[1]);

        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < p; i++) {
            String[] pair = br.readLine().split(" ");
            int a = Integer.parseInt(pair[0]);
            int b = Integer.parseInt(pair[1]);
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        visited = new boolean[n];
        List<Integer> countrySizes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int size = dfs(i);
                countrySizes.add(size);
            }
        }

        long totalPairs = (long)n * (n - 1) / 2;
        long sameCountryPairs = 0;

        for (int size : countrySizes) {
            sameCountryPairs += (long)size * (size - 1) / 2;
        }

        System.out.println(totalPairs - sameCountryPairs);
    }

    static int dfs(int node) {
        visited[node] = true;
        int count = 1;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                count += dfs(neighbor);
            }
        }
        return count;
    }
}