import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder s = new StringBuilder();
        Stack<String> history = new Stack<>();
        
        int Q = Integer.parseInt(reader.readLine());
        
        for (int i = 0; i < Q; i++) {
            String[] operation = reader.readLine().split(" ");
            int type = Integer.parseInt(operation[0]);
            
            switch (type) {
                case 1: // Append
                    String W = operation[1];
                    s.append(W);
                    history.push("1 " + W.length());
                    break;
                    
                case 2: // Delete
                    int k_delete = Integer.parseInt(operation[1]);
                    String deletedSubstring = s.substring(s.length() - k_delete);
                    s.delete(s.length() - k_delete, s.length());
                    history.push("2 " + deletedSubstring);
                    break;
                    
                case 3: // Print
                    int k_print = Integer.parseInt(operation[1]);
                    System.out.println(s.charAt(k_print - 1));
                    break;
                    
                case 4: // Undo
                    if (!history.isEmpty()) {
                        String lastOperation = history.pop();
                        String[] lastOpParts = lastOperation.split(" ", 2);
                        int lastOpType = Integer.parseInt(lastOpParts[0]);
                        
                        if (lastOpType == 1) { // Undo append
                            int appendedLength = Integer.parseInt(lastOpParts[1]);
                            s.delete(s.length() - appendedLength, s.length());
                        } else if (lastOpType == 2) { // Undo delete
                            String restoredString = lastOpParts[1];
                            s.append(restoredString);
                        }
                    }
                    break;
            }
        }
        
        reader.close();
    }
}
