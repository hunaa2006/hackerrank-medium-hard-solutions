import java.io.*;
import java.util.*;

class Result {
    static class Edge {
        int to;
        long cost;
        Edge(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static long bikeRacers(List<List<Integer>> bikers, List<List<Integer>> bikes, int k) {
        int n = bikers.size();
        int m = bikes.size();
        
        // Precompute all squared distances
        long[][] distances = new long[n][m];
        for (int i = 0; i < n; i++) {
            int x1 = bikers.get(i).get(0);
            int y1 = bikers.get(i).get(1);
            for (int j = 0; j < m; j++) {
                int x2 = bikes.get(j).get(0);
                int y2 = bikes.get(j).get(1);
                long dx = x1 - x2;
                long dy = y1 - y2;
                distances[i][j] = dx*dx + dy*dy;
            }
        }
        
        // Binary search on the maximum distance
        long left = 0;
        long right = Long.MAX_VALUE;
        long answer = Long.MAX_VALUE;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (isPossible(distances, n, m, k, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    private static boolean isPossible(long[][] distances, int n, int m, int k, long maxDist) {
        // Create bipartite graph where edges exist if distance <= maxDist
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            for (int j = 0; j < m; j++) {
                if (distances[i][j] <= maxDist) {
                    graph.get(i).add(j);
                }
            }
        }
        
        // Perform bipartite matching
        int[] match = new int[m];
        Arrays.fill(match, -1);
        int result = 0;
        
        for (int u = 0; u < n; u++) {
            boolean[] visited = new boolean[m];
            if (bpm(graph, u, visited, match)) {
                result++;
                if (result >= k) return true;
            }
        }
        
        return result >= k;
    }
    
    private static boolean bpm(List<List<Integer>> graph, int u, boolean[] visited, int[] match) {
        for (int v : graph.get(u)) {
            if (!visited[v]) {
                visited[v] = true;
                if (match[v] == -1 || bpm(graph, match[v], visited, match)) {
                    match[v] = u;
                    return true;
                }
            }
        }
        return false;
    }
}

public class Solution14 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        int k = Integer.parseInt(firstLine[2]);
        
        List<List<Integer>> bikers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] coords = br.readLine().split(" ");
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);
            bikers.add(Arrays.asList(x, y));
        }
        
        List<List<Integer>> bikes = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] coords = br.readLine().split(" ");
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);
            bikes.add(Arrays.asList(x, y));
        }
        
        long result = Result.bikeRacers(bikers, bikes, k);
        System.out.println(result);
    }
}