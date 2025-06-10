import java.util.*;
import java.io.*;

public class Solution12 {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int count = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Precompute all powers of 2 up to 2^800 (about 240 digits)
        int maxPower = 800;
        String[] powers = new String[maxPower + 1];
        powers[0] = "1";
        
        for (int i = 1; i <= maxPower; i++) {
            powers[i] = multiplyByTwo(powers[i - 1]);
        }

        // Build the trie
        TrieNode root = new TrieNode();
        for (String power : powers) {
            TrieNode node = root;
            for (char ch : power.toCharArray()) {
                if (!node.children.containsKey(ch)) {
                    node.children.put(ch, new TrieNode());
                }
                node = node.children.get(ch);
            }
            node.count++;
        }

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String S = br.readLine();
            long total = 0;
            
            // Check all possible substrings
            for (int i = 0; i < S.length(); i++) {
                TrieNode node = root;
                for (int j = i; j < S.length(); j++) {
                    char ch = S.charAt(j);
                    if (!node.children.containsKey(ch)) break;
                    node = node.children.get(ch);
                    total += node.count;
                }
            }
            
            bw.write(total + "\n");
        }
        
        bw.flush();
    }

    private static String multiplyByTwo(String num) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        
        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = num.charAt(i) - '0';
            int product = digit * 2 + carry;
            sb.append(product % 10);
            carry = product / 10;
        }
        
        if (carry != 0) {
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }
}