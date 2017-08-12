import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner (System.in);
        int n = in.nextInt(), k = in.nextInt(),i;
        int a[] = new int[n];
        for(i=0;i<n;i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        int ans = 0;
        for(i=0;i<n;i++) {
            while(2 * k < a[i]) {
                ans++;
                k *= 2;
            }
            k = Math.max(k, a[i]);
        }
        System.out.println(ans);
    }
}