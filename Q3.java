import java.util.Arrays;
import java.util.Scanner;
 
public class Main {
    static Scanner in = new Scanner(System.in);
 
    public static void main(String[] args) {
        int N = in.nextInt(), M = in.nextInt();
        int[] v = new int[N * N], w = new int[N * N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                v[i * N + j] = in.nextInt();
                w[i * N + j] = (i + 1) * (j + 1);
            }
        }
        
        int[][] dp = new int[N * N + 1][M + 1];
        Arrays.fill(dp[0], 0);
        for(int i = 1; i < N * N + 1; i++){
            for(int j = 1; j < M + 1; j++){
                if(j - w[i - 1] >= 0){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N * N][M]);
    }
}