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

    /*
     * Complete the 'highestValuePalindrome' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER n
     *  3. INTEGER k
     */

    public static String highestValuePalindrome(String s, int n, int k) {
        char[] chars = s.toCharArray();
        int changesNeeded = 0;

        // Calculate the minimal changes needed to make the string a palindrome
        for (int i = 0; i < n / 2; i++) {
            if (chars[i] != chars[n - 1 - i]) {
                changesNeeded++;
            }
        }

        if (changesNeeded > k) {
            return "-1";
        }

        int remainingChanges = k - changesNeeded;

        // First pass: make the string a palindrome by setting pairs to the max of the two
        for (int i = 0; i < n / 2; i++) {
            int j = n - 1 - i;
            if (chars[i] != chars[j]) {
                char maxChar = (char) Math.max(chars[i], chars[j]);
                if (remainingChanges > 0 && maxChar != '9') {
                    chars[i] = '9';
                    chars[j] = '9';
                    remainingChanges--;
                } else {
                    chars[i] = maxChar;
                    chars[j] = maxChar;
                }
            } else {
                // Both are same, check if we can upgrade to '9'
                if (remainingChanges >= 2 && chars[i] != '9') {
                    chars[i] = '9';
                    chars[j] = '9';
                    remainingChanges -= 2;
                }
            }
        }

        // Handle the middle character for odd-length strings
        if (n % 2 == 1 && remainingChanges > 0) {
            chars[n / 2] = '9';
        }

        return new String(chars);
    }
}

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String s = bufferedReader.readLine();

        String result = Result.highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}