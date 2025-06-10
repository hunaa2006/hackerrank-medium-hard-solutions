import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution13 {

    static int buildString(int a, int b, String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // empty string costs 0
        
        for (int i = 1; i <= n; i++) {
            // Option 1: Add single character
            dp[i] = Math.min(dp[i], dp[i - 1] + a);
            
            // Option 2: Find longest possible substring to copy
            int maxLen = 0;
            for (int j = 0; j < i; j++) {
                int len = 0;
                while (j + len < i && i + len < n && 
                       s.charAt(j + len) == s.charAt(i + len)) {
                    len++;
                }
                if (len > maxLen) {
                    maxLen = len;
                }
            }
            
            // Try all possible copy lengths
            for (int len = 1; len <= maxLen; len++) {
                if (i + len <= n) {
                    dp[i + len] = Math.min(dp[i + len], dp[i] + b);
                }
            }
        }
        
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);
                int a = Integer.parseInt(firstMultipleInput[1]);
                int b = Integer.parseInt(firstMultipleInput[2]);

                String s = bufferedReader.readLine();

                int result = buildString(a, b, s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}