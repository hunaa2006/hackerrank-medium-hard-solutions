import java.io.*;
import java.util.*;

public class Solution6 {

    public static void main(String[] args) throws IOException { 
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        Stack<Integer> stack1 = new Stack<>(); 
        Stack<Integer> stack2 = new Stack<>(); 
        
        for (int i = 0; i < q; i++) {
            String[] queryParts = bufferedReader.readLine().trim().split(" ");
            int type = Integer.parseInt(queryParts[0]); 

            switch (type) {
                case 1: 
                    int x = Integer.parseInt(queryParts[1]); 
                    stack1.push(x); 
                    break;
                case 2: 
                    if (stack2.isEmpty()) {
                        while (!stack1.isEmpty()) {
                            stack2.push(stack1.pop());
                        }
                    }
                    if (!stack2.isEmpty()) {
                        stack2.pop(); 
                    }
                    break; 
                case 3:
                    if (stack2.isEmpty()) {
                        while (!stack1.isEmpty()) {
                            stack2.push(stack1.pop());
                        }
                    }
                    if (!stack2.isEmpty()) {
                        System.out.println(stack2.peek());
                    }
                    break;
            }
        }
        bufferedReader.close(); 
    }
}
