import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    private static final int MOD = 1000000007;
    private static final int MAX_XOR = 8192;

    public static int primeXor(List<Integer> a) {
        boolean[] isPrime = sieve(MAX_XOR - 1);
        int[] freq = new int[4501];
        for (int num : a) freq[num]++;

        long[] dp = new long[MAX_XOR];
        dp[0] = 1;

        for (int num = 3500; num <= 4500; num++) {
            if (freq[num] == 0) continue;

            long[] temp = new long[MAX_XOR];
            int cnt = freq[num];
            long even = (cnt / 2) + 1;
            long odd = ((cnt + 1) / 2);

            for (int i = 0; i < MAX_XOR; i++) {
                temp[i] = (dp[i] * even + dp[i ^ num] * odd) % MOD;
            }
            dp = temp;
        }

        long result = 0;
        for (int i = 2; i < MAX_XOR; i++) {
            if (isPrime[i]) result = (result + dp[i]) % MOD;
        }
        return (int) result;
    }

    private static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}

public class Solution6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(br.readLine().trim());
        while (q-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            List<Integer> a = Arrays.stream(br.readLine().trim().split(" "))
                                  .map(Integer::parseInt)
                                  .collect(Collectors.toList());
            int result = Result.primeXor(a);
            bw.write(result + "\n");
        }

        br.close();
        bw.close();
    }
}