package 실전코테스터디.Algo_0806;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 고리는 그냥 2명일 수도 있고, 아예 N명 모두가 포함될 수도 있다.
 *  N명의 사람들 사이에서 이러한 연결 고리가 몇 개나 발생하는지를 알아내는 것
 *
 *  첫 번째 줄에는 사람의 명수 N이 주어진다(3 <= N <=20) 만약 N = 0이면 입력의 끝을 의미
 *
 */

public class Manito {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("res/manito.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int count = 1;
        while(true){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());

            if(N == 0) {
                break;
            }
            HashMap<String,String> map = new HashMap<>();
            for(int i = 0;i < N;i++){
                StringTokenizer st2 = new StringTokenizer(bf.readLine());
                String str = st2.nextToken();
                String dpt = st2.nextToken();

                map.put(str,dpt);
            }

            Set<String> keys = map.keySet();
            Object[] keyset = keys.toArray();
            int answer = 0;

            for(int i = 0;i < keyset.length;i++){
                String key = (String) keyset[i];
                while (map.containsKey(key)){
                    String next = map.get(key);
                    map.remove(key);
                    key = next;

                    if(!map.containsKey(next)){
                        answer++;
                        break;
                    }
                }
            }

            System.out.println(count + " " + answer);
            count++;
        }


    }
}
