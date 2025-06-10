import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'minimumMoves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING_ARRAY grid
     *  2. INTEGER startX
     *  3. INTEGER startY
     *  4. INTEGER goalX
     *  5. INTEGER goalY
     */

    public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY) {
        int n = grid.size();
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1); 
        }
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{startX, startY});
        dist[startX][startY] = 0; 
        int[] dr = {0, 0, 1, -1}; 
        int[] dc = {1, -1, 0, 0};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int currentMoves = dist[r][c];

            if (r == goalX && c == goalY) {
                return currentMoves;
            }

            for (int i = 0; i < 4; i++) { 
                int nextR = r; 
                int nextC = c; 
                while (true) {
                    nextR += dr[i]; 
                    nextC += dc[i]; 

                    if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= n || grid.get(nextR).charAt(nextC) == 'X') {
                        break; 
                    }

                    if (dist[nextR][nextC] == -1) {
                        dist[nextR][nextC] = currentMoves + 1; 
                        queue.offer(new int[]{nextR, nextC}); 
                    } else if (dist[nextR][nextC] == currentMoves + 1) {
                        continue; 
                    } else { 
                        break; 
                    }
                }
            }
        }
        
        return -1;
    // Write your code here

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String gridItem = bufferedReader.readLine();
            grid.add(gridItem);
        }

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int startX = Integer.parseInt(firstMultipleInput[0]);

        int startY = Integer.parseInt(firstMultipleInput[1]);

        int goalX = Integer.parseInt(firstMultipleInput[2]);

        int goalY = Integer.parseInt(firstMultipleInput[3]);

        int result = Result.minimumMoves(grid, startX, startY, goalX, goalY);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
