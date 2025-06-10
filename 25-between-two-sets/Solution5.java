import java.util.*;

public class Solution5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        
        int lcm_a = a[0];
        for (int i = 1; i < n; i++) {
            lcm_a = lcm(lcm_a, a[i]);
        }
        
        int gcd_b = b[0];
        for (int i = 1; i < m; i++) {
            gcd_b = gcd(gcd_b, b[i]);
        }
        
        if (gcd_b % lcm_a != 0) {
            System.out.println(0);
            return;
        }
        
        int count = 0;
        for (int x = lcm_a; x <= gcd_b; x += lcm_a) {
            if (gcd_b % x == 0) {
                count++;
            }
        }
        
        System.out.println(count);
    }
    
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    private static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }
}