package 실전코테스터디.Algo_0801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * n-1회차 문장일 때는 ‘뻔 – 데기 – 뻔 – 데기 – 뻔(x n번) – 데기(x n번)’이 된다
 * 첫째 줄에 게임을 진행하는 사람 A명이 주어진다. A는 2,000보다 작거나 같은 자연수이다.
 *
 * 둘째 줄에는 구하고자 하는 번째 T가 주어진다. (T ≤ 10000)
 *
 * 셋째 줄에는 구하고자 하는 구호가 “뻔”이면 0, “데기”면 1로 주어진다.
 */

public class Cocun {
    public static void main(String[] args) throws  Exception{
        System.setIn(new FileInputStream("res/cocun.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int A = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(bf.readLine());
        int T = Integer.parseInt(st2.nextToken());
        StringTokenizer st3 = new StringTokenizer(bf.readLine());
        int goal = Integer.parseInt(st3.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        int count = 0;
        int total = 0;
        int repeat = 2;
        while(true){
            queue.add(0);
            queue.add(1);
            queue.add(0);
            queue.add(1);
            for(int i = 0;i < repeat;i++){
                queue.add(0);
            }
            for(int i = 0;i < repeat;i++){
                queue.add(1);
            }

            while(!queue.isEmpty()){
                int curr = queue.poll();
                if(curr == goal){
                    count++;
                }
                total = total % A;
                if(count == T){
                    break;
                }
                total++;
            }
            if(count == T){
                System.out.println(total);
                break;
            }
            repeat++;
        }

    }
}
