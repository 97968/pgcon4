スコード
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] list = new int[26 * 26];
        Arrays.fill(list, 0);
        int a = br.read();
        int b;
        while((b = br.read()) != -1){
            if(a != '\n' && b!= '\n'){
                list[(a - 'A') * 26 + (b - 'A')]++;
            }
            a = b;
        }
        boolean f = true;
        for(int i = 0; i < 10; i++){
            int max  = 0, value = 0;
            for(int j = 0; j < 26 * 26; j++){
                if(max < list[j]){
                    f = false;
                    max = list[j];
                    value = j;
                }
            }
            if(max == 0){
                break;
            }
            char c = (char)('A' + value / 26);
            char d = (char)('A' + value % 26);
            String s = c + "" + d;
            System.out.println(c + "" + d + " " + max);
            list[value]= 0;
            max = 0;
        }
        if(f){
            System.out.println();
        }
    }
}