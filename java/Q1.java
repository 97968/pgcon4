import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Main {
 
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isUpperCase(c)){
                System.out.print(Character.toLowerCase(c));
            }else if(Character.isLowerCase(c)){
                System.out.print(Character.toUpperCase(c));
            }else{
                System.out.print(c);
            }
        }
        System.out.println();
    }
}