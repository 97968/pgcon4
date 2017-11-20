import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] list = new int[26 * 26];
        int ch1 = '\n';
        int ch2;
        while((ch2 = br.read()) != -1){
            if(ch1 != '\n' &&'A' <= ch2 && ch2 <= 'Z'){
                list[(ch1 - 'A') * 26 + (ch2 - 'A')]++;
            }
            ch1 = ch2;
        }
        int i;
        for(i = 0; i < 10; i++){
            int max  = 0, idx = 0;
            for(int j = 0; j < 26 * 26; j++){
                if(max < list[j]){
                    max = list[j];
                    idx = j;
                }
            }
            if(max == 0){
                break;
            }
            char ch3 = (char)('A' + idx / 26);
            char ch4 = (char)('A' + idx % 26);
            System.out.println(ch3 + "" + ch4 + " " + max);
            list[idx]= 0;
        }
        if(i == 0){
            System.out.println();
        }
    }
}