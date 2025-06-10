import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'solve' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int solve(List<Integer> arr) {
        int n = arr.size();
        if (n == 0) {
            return 0;
        }
        int[] L_values = new int[n];
        int[] R_values = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr.get(stack.peek()) <= arr.get(i)) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                L_values[i] = 0;
            } else {
                L_values[i] = stack.peek() + 1;
            }
            stack.push(i); 
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr.get(stack.peek()) <= arr.get(i)) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                R_values[i] = 0;
            } else {
                R_values[i] = stack.peek() + 1;
            }
            stack.push(i); 
        }

        long max_p = 0; 

        for (int i = 0; i < n; i++) {
            long current_p = (long) L_values[i] * R_values[i]; 
            if (current_p > max_p) {
                max_p = current_p;
            }
        }

        return (int) max_p;
    // Write your code here

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        int result = Result.solve(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

