import java.io.*;
import java.util.*;
/*

 */
public class p12933 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String recorded = br.readLine().trim();
        String sound = "quack";
        int duckCnt = 0;
        //boolean[] duck = new boolean[2500];
        int[] duck = new int[2500];
        //모든 소리에 대해 순회
        for(char c : recorded.toCharArray()){
            //indexOf -> 값 없으면 -1 리턴
            int idx = sound.indexOf(c);
            //기저
            if(idx == -1){
                System.out.println(-1);
                return;
            }

            //알맞은 알파벳을 찾은경우 트리거
            boolean flag = false;
            //기존 오리가 울 경우
            for(int i=0;i<duckCnt;i++){
                //기존 오리에서 지금 알파벳이 와야하는 오리가 있는가?
                //있다면
                if(duck[i] == idx){
                    duck[i] = (idx+1)%5; // 인덱스 하나 옮기기
                    flag = true;
                    break;
                }
            }
            
            //새로운 오리가 울기 시작하는 경우
            if(!flag){
                //0번째 인덱스라는 말은 q라는 말이고, 새로 울기 시작한다
                if(idx == 0){
                    duck[duckCnt++] = 1;

                //q가 아니면 시작조차 할 수 없음
                }else{
                    System.out.println(-1);
                    return;
                }
            }
        }

        //모든 알파벳이 제대로 매치되지 않은 경우 -> -1
        for(int i=0;i<duckCnt;i++){
            //mod연산을 이용했으므로 제대로된 루프라면 배열에 0이 들어가있다
            if(duck[i] != 0){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(duckCnt == 0 ? -1 : duckCnt);
    }
}
