import java.util.Scanner;
 
public class Main {
    static Scanner in = new Scanner(System.in);
 
    public static void main(String[] args) {
        String s = in.nextLine();
 
        long ans = 0, c = 1;
        for(int i = s.length(); i > 0; i--){
            long t = Long.parseLong(s.substring(Math.max(0,  i - 6), i));
            c = (c * Math.min(3, s.length() - i + 1)) % 1000000;
            t = (t % 1000000) * c;
            ans = (ans + t) % 1000000;
        }
        System.out.println(ans % 1000000);
    }
}