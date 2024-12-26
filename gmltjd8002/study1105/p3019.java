
import java.io.*;
import java.util.*;
public class p3019 {
    static int c,p,cnt;
    static int[] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine().trim());
        c = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        map = new int[c];
        cnt =0;
        st = new StringTokenizer(br.readLine().trim());
        for(int i=0;i<c;i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        rotateAndMove();
        System.out.println(cnt);
    }

    //canDeploy -> 밑에 구멍 있는지 확인
    private static void rotateAndMove(){
        switch(p){
            //1번 0도 -> 무조건 될거같다
            case 1:
                cnt++;

                //1번 90도
                for(int i=0;i<c-4;++i){ //가로로 눕힌게 0번부터 배열끝까지 돈다
                    if(canDeploy(i)) cnt++;
                }

                //1번 180도 -> 0도랑 똑같음
                cnt++;

                //1번 270도 -> 가로랑 똑같음
                for(int i=0;i<c-4;++i){ //가로로 눕힌게 0번부터 배열끝까지 돈다
                    if(canDeploy(i)) cnt++; //
                }
            case 2: //정사각형
                for(int i=0;i<c-2;++i){
                    if(canDeploy(i)) cnt++;
                }
            case 3: //우상향 지그재그
                //3번 0도
                for(int i=0;i<c-3;++i){
                    //바닥에 닿을칸이 0이면서 그 다음칸은 채워져있어야함
                    if((map[i] == 0 && map[i+1] == 0 && map[i+2] == 1)) cnt+=2; //0,180은 같으므로 두번
                }
                //3번 90도
                for(int i=0;i<c-2;++i){
                    if(map[i] == 1 && map[i+1] == 0) cnt+=2; //90,270도 같으니깐 두번
                }
            case 4:
                //4번 0도
                for(int i=0;i<c-3;++i){
                    //바닥에 닿을칸이 0이면서 그 다음칸은 채워져있어야함
                    if((map[i] == 1 && map[i+1] == 0 && map[i+2] == 0)) cnt+=2; //0,180은 같으므로 두번
                }
                //4번 90도
                for(int i=0;i<c-2;++i){
                    if(map[i] == 0 && map[i+1] == 1) cnt+=2; //90,270도 같으니깐 두번
                }               
            case 5: //ㅗ... 
                //5번 0도
                
        }
    }
}
/*
 * 1. 1~7번 블록을 어떻게 정의할 것인가? 탈주범처럼 미리 선언?
 * 2. 동작과정
 *  2-1. 각 번호 0도 모양이 아래로 떨어짐
 *  2-2. 한칸이동 -> 배열 마지막까지 반복
 *  2-3. 90도 회전 -> 0번 배열부터 마지막까지 2-2
 *  2-4. 180도 회전 -> 반복
 * 될때마다 cnt++
 *  */