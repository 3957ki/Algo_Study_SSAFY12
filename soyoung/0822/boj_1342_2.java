import java.io.*;
import java.util.*;

public class boj_1342_2 {
    static String str;
    static int[] alphabet = new int[27];
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str = br.readLine();
        //알파벳이 몇 갠지 세기
        for(int i=0; i<str.length(); i++){
            alphabet[str.charAt(i)-'a']++;
        }

        char c = ' ';
        select(c, 0);
        bw.write(ans+"");
        bw.close();

    }
    static void select(char c, int len){
        if(len == str.length()){
            ans++;
            return;
        }
        for(int i=0; i<27; i++){
            char now = (char)(i+'a');
            if(alphabet[i] == 0)
                continue;
            if(c == now) //같은 문자 제외
                continue;
            alphabet[i]--;
            select(now, len+1);
            alphabet[i]++;
        }
    }
}
