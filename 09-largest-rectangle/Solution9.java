import java.io.*;
import java.util.*;

class Result {

    public static long largestRectangle(List<Integer> h) {
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;
        int i = 0;
        int n = h.size();

        while (i < n) {
            if (stack.isEmpty() || h.get(stack.peek()) <= h.get(i)) {
                stack.push(i);
                i++;
            } else {
                int top = stack.pop();
                long currentHeight = h.get(top);
                long width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * width);
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            long currentHeight = h.get(top);
            long width = stack.isEmpty() ? i : i - stack.peek() - 1;
            maxArea = Math.max(maxArea, currentHeight * width);
        }

        return maxArea;

    // Write your code here

    }

}

public class Solution9 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] hTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hTemp[i]);
            h.add(hItem);
        }

        long result = Result.largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
