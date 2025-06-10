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

class Result {

    private static final int MOD = 1000000007;

    public static int shortPalindrome(String s) {
        long total = 0;
        int[] c1 = new int[26]; // counts of each character
        int[][] c2 = new int[26][26]; // c2[a][b] is the count of a followed by b
        int[][][] c3 = new int[26][26][26]; // c3[a][b][c] is the count of a followed by b followed by c

        for (char ch : s.toCharArray()) {
            int d = ch - 'a';
            // Update total: for current d, we look for all a such that there exists c3[a][b][b] (i.e., a followed by b followed by b)
            for (int b = 0; b < 26; b++) {
                total = (total + c3[d][b][b]) % MOD;
            }
            // Update c3: for current d, any existing c2[a][b] becomes part of c3[a][b][d]
            for (int a = 0; a < 26; a++) {
                for (int b = 0; b < 26; b++) {
                    c3[a][b][d] = (c3[a][b][d] + c2[a][b]) % MOD;
                }
            }
            // Update c2: for current d, any existing c1[a] becomes part of c2[a][d]
            for (int a = 0; a < 26; a++) {
                c2[a][d] = (c2[a][d] + c1[a]) % MOD;
            }
            // Update c1: increment count of current character d
            c1[d]++;
        }
        return (int) total;
    }
}

public class Solution17 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result.shortPalindrome(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}