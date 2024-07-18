# SSAFY 12th 알고리즘 스터디 07/18

## 박준호


1. 큰 수 구성하기
빠르게 풀기 위해서 생각나는대로 코드를 작성했더니 시간초과 되어 문제를 해결하지 못했다.
항상 문제를 풀때는 생각을 정리하고 푸는게 가장 빠르다고 생각하자.

2. 알바생 강호
생각보다 어렵지 않았지만 알고리즘의 유형을 먼저 생각하고 접근해보는 것은 어떨까?

3. 꽃길
백트래킹 유형의 문제
평소에 그래프 문제만 풀다가 다른 유형의 문제 풀기가 어렵다고 느껴진다. 다양한 유형의 문제를 풀어보자
# 14620 꽃길

```java
private static void solution(int x, int y, int count) {
  if (count == 3) {

      if (isPlant()) {
          minPrice = Math.min(minPrice, calcPrice());
      }
  } else {
      for (int i = x; i < N - 1; i++) {
          for (int j = y; j < N - 1; j++) {

              if (!visited[i][j]) {
                  if (count == 0) {
                      System.out.print("count: 1 ( " + i + ", " + j +" ), ");
                  } else if (count == 1) {
                      System.out.println( "count: 2 ( " + i + ", " + j +" )");
                  } else {
                      System.out.println(" ( " + i + ", " + j +" )");
                  }
                  visited[i][j] = true;
                  solution(i, j, count + 1);
                  visited[i][j] = false;
              }

          }
      }
  }
}
```

7월 18일 따스한 여름의 싸피 방과후를 날려버린 문제

`for (int i = x; i < N - 1; i++) {
   for (int j = y; j < N - 1; j++) {`

문제의 코드는 다음과 같다.

### 위의 백트래킹 반복문에서 x, y의 값이 들어가면 탐색범위가 어떻게 되는가?

결론을 말하자면 답은 다음과 같다

- 외부 루프: int i = x, 내부 루프: int j = y 일때
    - 탐색범위는 대각선 범위로 줄어든다
        
        
- 외부 루프: int i = x, 내부 루프: int j = 1 일때
    - 탐색범위는 직사각형으로 높이가 줄어든다
        
- 외부 루프: int i = 1, 내부 루프: int j = y 일때
    - 탐색범위는 직사각형으로 너비가 줄어든다.
