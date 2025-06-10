import java.io.*;

public class Solution11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String a = br.readLine();
            String b = br.readLine();
            String result = morganAndString(a, b);
            bw.write(result);
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    public static String morganAndString(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        int n = a.length(), m = b.length();
        
        while (i < n && j < m) {
            if (a.charAt(i) < b.charAt(j)) {
                sb.append(a.charAt(i++));
            } else if (a.charAt(i) > b.charAt(j)) {
                sb.append(b.charAt(j++));
            } else {
                // When characters are equal, we need to look ahead
                int x = i, y = j;
                while (x < n && y < m && a.charAt(x) == b.charAt(y)) {
                    x++;
                    y++;
                }
                
                if (x == n) {
                    sb.append(a.charAt(i++));
                } else if (y == m) {
                    sb.append(b.charAt(j++));
                } else if (a.charAt(x) < b.charAt(y)) {
                    sb.append(a.charAt(i++));
                } else {
                    sb.append(b.charAt(j++));
                }
            }
        }
        
        // Append remaining characters
        while (i < n) sb.append(a.charAt(i++));
        while (j < m) sb.append(b.charAt(j++));
        
        return sb.toString();
    }
}