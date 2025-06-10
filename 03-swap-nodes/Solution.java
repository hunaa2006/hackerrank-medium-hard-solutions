import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
     static class Node {
        int data;
        int depth;
        Node left;
        Node right;

        Node(int data, int depth) {
            this.data = data;
            this.depth = depth;
            this.left = null;
            this.right = null;
        }
    }

    /*
     * Complete the 'swapNodes' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY indexes
     *  2. INTEGER_ARRAY queries
     */

    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
         List<List<Integer>> results = new ArrayList<>();

        Node root = new Node(1, 1);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 0;

        while (!queue.isEmpty() && i < indexes.size()) {
            Node current = queue.poll();
            List<Integer> children = indexes.get(i++);

            int leftChildVal = children.get(0);
            if (leftChildVal != -1) {
                current.left = new Node(leftChildVal, current.depth + 1);
                queue.add(current.left);
            }

            int rightChildVal = children.get(1);
            if (rightChildVal != -1) {
                current.right = new Node(rightChildVal, current.depth + 1);
                queue.add(current.right);
            }
        }

        for (int k : queries) {
            Queue<Node> swapQueue = new LinkedList<>();
            swapQueue.add(root);

            while (!swapQueue.isEmpty()) {
                Node current = swapQueue.poll();

                if (current.depth % k == 0) {
                    Node temp = current.left;
                    current.left = current.right;
                    current.right = temp;
                }

                if (current.left != null) {
                    swapQueue.add(current.left);
                }
                if (current.right != null) {
                    swapQueue.add(current.right);
                }
            }

            List<Integer> inOrderResult = new ArrayList<>();
            inOrderTraversal(root, inOrderResult);
            results.add(inOrderResult);
        }

        return results;
    }

    private static void inOrderTraversal(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, result);
        result.add(node.data);
        inOrderTraversal(node.right, result);
    // Write your code here

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> indexes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] indexesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> indexesRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int indexesItem = Integer.parseInt(indexesRowTempItems[j]);
                indexesRowItems.add(indexesItem);
            }

            indexes.add(indexesRowItems);
        }

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = new ArrayList<>();

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = Integer.parseInt(bufferedReader.readLine().trim());
            queries.add(queriesItem);
        }

        List<List<Integer>> result = Result.swapNodes(indexes, queries);

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                bufferedWriter.write(String.valueOf(result.get(i).get(j)));

                if (j != result.get(i).size() - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
