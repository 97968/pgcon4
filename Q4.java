import java.util.Scanner;
 
public class Main {
    static Scanner in = new Scanner(System.in);
 
    public static void main(String[] args) {
        String s = in.nextLine();
 
        long ans = 0;
        for (int i = 1; i <= s.length(); i++) {
            long t = Long.parseLong(s.substring(Math.max(0, i - 6), i));
            t *= i == s.length() ? 1 : 2 * (long)Math.pow(3, s.length() - 1 - i);
            ans = (ans + t) % 1000000;
        }
        System.out.println(ans % 1000000);
    }
}