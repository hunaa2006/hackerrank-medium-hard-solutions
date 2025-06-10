import java.util.Scanner;

public class Solution18 {
    public static int commonChild(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Dynamic Programming table fill
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // Match
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // No match
                }
            }
        }

        return dp[m][n]; // Final cell has the length of longest common child
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine().trim();
        String s2 = scanner.nextLine().trim();
        System.out.println(commonChild(s1, s2));
    }
}