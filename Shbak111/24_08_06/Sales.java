package 실전코테스터디.Algo_0806;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. 무려 N명이나 살 의향을 보였다. 각각의 사람은 자기가 지불할 생각이 있는 최대 한도가 있다
 * 2. N명의 사람과, 각각의 사람이 지불할 용의가 있는 최대 금액과 배송비가 주어졌을 때, 세준이의 이익을 최대로 하는 가격을 출력하는 프로그램을 작성하시오.
 * 3. 첫째 줄에 세준이의 물건을 구매할 의향이 있는 사람의 수 N이 주어진다. 이 값은 50보다 작거나 같다.
 * 이익이 최대인 가격이 여러개라면, 가장 낮은 가격을 출력한다.
 * 어떤 가격으로 팔아도 이익을 남길 수 없다면 0을 출력
 */

public class Sales {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/sales.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        long[] marr = new long[N];
        long[] tarr = new long[N];

        for(int i = 0;i < N;i++){
            StringTokenizer st2 = new StringTokenizer(bf.readLine());
            int max = Integer.parseInt(st2.nextToken());
            int tax = Integer.parseInt(st2.nextToken());

            marr[i] = max;
            tarr[i] = tax;
        }

        long sum = 0;
        long number = 0;
        for(int i = 0;i < N;i++){
            long curr = marr[i];
            long temp = 0;
            for(int j = 0;j < N;j++){
                if(marr[j] >= curr) {
                    if(curr - tarr[j] >= 0){
                        temp += (curr - tarr[j]);
                    }
                }
            }
            if(temp > sum){
                number = curr;
                sum = temp;
            } else if(temp == sum){
                if(curr < number){
                    number = curr;
                }
            }
            //System.out.println(curr + " " + temp);
        }
        System.out.println(number);
    }
}
