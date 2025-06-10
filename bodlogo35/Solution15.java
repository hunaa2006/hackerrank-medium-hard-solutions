import java.io.*;
import java.util.*;

class Result {
    static class Edge implements Comparable<Edge> {
        int u, v, time;
        Edge(int u, int v, int time) {
            this.u = u;
            this.v = v;
            this.time = time;
        }
        @Override
        public int compareTo(Edge other) {
            return other.time - this.time; // Sort in descending order
        }
    }

    static int[] parent;
    static boolean[] hasMachine;

    public static int minTime(List<List<Integer>> roads, List<Integer> machines) {
        int n = roads.size() + 1;
        int k = machines.size();
        
        // Initialize Union-Find structures
        parent = new int[n];
        hasMachine = new boolean[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int machine : machines) {
            hasMachine[machine] = true;
        }
        
        // Create and sort edges
        List<Edge> edges = new ArrayList<>();
        for (List<Integer> road : roads) {
            int u = road.get(0);
            int v = road.get(1);
            int time = road.get(2);
            edges.add(new Edge(u, v, time));
        }
        Collections.sort(edges);
        
        int totalTime = 0;
        
        // Process edges in descending order of time
        for (Edge edge : edges) {
            int rootU = find(edge.u);
            int rootV = find(edge.v);
            
            if (hasMachine[rootU] && hasMachine[rootV]) {
                // Both components have machines, must remove this edge
                totalTime += edge.time;
            } else {
                // Union the components
                parent[rootV] = rootU;
                hasMachine[rootU] = hasMachine[rootU] || hasMachine[rootV];
            }
        }
        
        return totalTime;
    }
    
    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}

public class Solution15 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int k = Integer.parseInt(firstLine[1]);
        
        List<List<Integer>> roads = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            String[] roadData = br.readLine().split(" ");
            int u = Integer.parseInt(roadData[0]);
            int v = Integer.parseInt(roadData[1]);
            int time = Integer.parseInt(roadData[2]);
            roads.add(Arrays.asList(u, v, time));
        }
        
        List<Integer> machines = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            machines.add(Integer.parseInt(br.readLine()));
        }
        
        int result = Result.minTime(roads, machines);
        System.out.println(result);
    }
}