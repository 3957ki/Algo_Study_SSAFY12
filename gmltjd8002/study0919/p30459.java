package study0919;

import java.io.*;
import java.util.*;

/*
알아낸점
폴대를 꼽는다고 가정하면 어디에 꼽든 높이는 항상 최고점이므로 같다
이분탐색인거같다
1. 말뚝 두개를 이분탐색을 하며 길이를 구한다.
    1-1. 그 때 폴대높이를 이용해 삼각형 높이를 구한다
        1-2-1. 이게 R보다 크면 high를 줄인다
        1-2-2. 이게 R보다 이하면 low를 mid+1로 늘린다음 max값 갱신하기
Q) 폴대 높이를 어떻게 정해야할까?
A1) 완탐으로 작은거부터 선택해본다(시간복잡도 때메 터지겠지?)
A2) 이것도 이분탐색으로 범위를 줄여나간다
-> 애초에 이분탐색할 low와 high가 m을 기준으로 해야하나?
-> 어차피 말뚝은 반복문으로 두개만 고르면 되고, 폴대 길이랑 위치가 가변이다
-> 다른 이분탐색들은 값 자체를 바로 비교하지만 이건 배열 내부에 값이 들어가있다.
-> 따라서 인덱스를 이분탐색해서 돌리는게 맞다
 */

public class p30459 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 말뚝 수
        int m = Integer.parseInt(st.nextToken()); // 폴대 수
        int r = Integer.parseInt(st.nextToken()); // 최대넓이
        int[] pile = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            pile[i] = Integer.parseInt(st.nextToken());
        }

        int[] flag = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            flag[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(flag); // 이분탐색하려면 flag 길이순 정렬
        // for(int i : flag){
        //     System.out.print(i + " ");
        // }
        double res = -1; // 끝까지 이값이면 그냥 -1출력
        for(int i=0;i<n-1;i++){ // 왼쪽 말뚝 선택
            for(int j= i+1; j<n;j++){ //오른쪽 말뚝 선택
                int width = Math.abs(pile[j] - pile[i]); // 절대값 사용
                int low = 0; // 이게 사실 flag 인덱스다
                int high = m-1; // 이것도
                while(low <= high){
                    int mid = (low + high) / 2; //이분
                    //면적 = (오른쪽 말뚝 - 왼쪽 말뚝) * 높이(폴대) / 2 -> 죄다 int니깐 double로 형변환
                    double area = (double) (width * flag[mid]) /2 ;
                    if(area <= r){ // 최대 넓이를 넘지 않는경우
                        low = mid+1; // low를 땡긴다
                        res = Math.max(area, res); //최대값 갱신가능하면 갱신하고
                    }else{ // 넘어버린다면?
                        high = mid-1; // high를 땡긴다
                    }
                }
            }
        }
        System.out.println(res == -1 ? -1 : String.format("%.1f", res));
    }
}