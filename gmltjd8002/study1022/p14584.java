import java.io.*;
import java.util.*;
/*
시프트를 몇번 했는지 모른다
str배열을 shiftCnt를 늘려가며 각 자리마다 대입해본다 -> 암호문 전체를 한칸씩 밀어본다
(cipher[j] - 'a' + 1) % 26 + 'a' -> 현재 문자를 정수형으로 바꾼 다음 한칸 시프트하고 모듈러 연산 후 다시 char 형태로 바꾼다
 */
public class p14584 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] cipher = br.readLine().trim().toCharArray(); // 리스트 char 형태로 만들기
        int cipherLen = cipher.length;
        int n = Integer.parseInt(br.readLine().trim());
        String[] str = new String[n];

        //사전 단어 받기
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine().trim();
        }

        for (int i = 0; i < 26; i++) { //알파벳 전부 시프트
            for (int j = 0; j < cipherLen; j++) {
                cipher[j] = (char) ((cipher[j] - 'a' + 1) % 26 + 'a');
            }

            //밀린 문자열
            String shifted = String.valueOf(cipher);
            for (int k = 0; k < n; k++) {
                if (shifted.contains(str[k])) {
                    System.out.println(shifted);
                    return;
                }
            }
        }
    }
}