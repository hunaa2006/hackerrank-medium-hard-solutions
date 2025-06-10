import java.util.*;

public class Solution8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        int[][] A = new int[H][W];
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                A[i][j] = scanner.nextInt();
            }
        }
        
        System.out.println(surfaceArea(A));
        scanner.close();
    }
    
    public static int surfaceArea(int[][] A) {
        int surface = 0;
        int H = A.length;
        int W = A[0].length;
        
        // Top and bottom surfaces
        surface += 2 * H * W;
        
        // Four side surfaces
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                for (int k = 0; k < 4; k++) {
                    int ni = i + dr[k];
                    int nj = j + dc[k];
                    
                    if (ni >= 0 && ni < H && nj >= 0 && nj < W) {
                        surface += Math.max(0, A[i][j] - A[ni][nj]);
                    } else {
                        surface += A[i][j];
                    }
                }
            }
        }
        
        return surface;
    }
}