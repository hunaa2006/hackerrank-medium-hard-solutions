import java.io.*;
import java.util.*;

public class Solution {

    static long arrayManipulation(int n, int[][] queries) {
        long[] result = new long[n];
        int length = queries.length;
        long max = Long.MIN_VALUE;

        for (int i = 0; i < length; i++) {
            int start = queries[i][0] - 1;
            int end = queries[i][1] - 1;
            int add = queries[i][2];
            result[start] += add;
            if (end + 1 < n) {
                result[end + 1] -= add;
            }
        }

        long temp = result[0];
        max = temp;
        for (int i = 1; i < n; i++) {
            result[i] += result[i - 1];
            if (result[i] > max) {
                max = result[i];
            }
        }

        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
