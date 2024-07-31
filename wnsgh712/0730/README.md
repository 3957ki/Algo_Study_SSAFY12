# 07-30

1번 

풀이: DP

피보나치 비스무리한 수열

https://www.acmicpc.net/problem/14495

https://www.acmicpc.net/problem/17216

2번

풀이: 뒤에서부터 DP

가장 큰 감소 부분 수열

3번

연구소 2

https://www.acmicpc.net/problem/17141

풀이: DFS로 조합 백트래킹 + BFS 탐색

이슈: 나의 풀이가 다른 풀이보다 10배 정도 실행시간 차이가 났음

다른 풀이와 비교하면서 여러가지를 익혔다.

- 다른 사람 풀이
    - 연구소 지도에서  바이러스가 잘 퍼졌는지 확인하기 위해서 blank 변수를 선언해서 BFS에서 체크할 수 있음
    - 하나의 배열에서 값들을 변형해서 메모리를 절약함
- 나의 풀이
    - 연구소 탐색이 끝난 뒤 2중 반복을 통해서 바이러스가 퍼졌는지 체크함
    - 방문 배열, 탐색 배열 2개의 배열로 나누어서 검색하였음

배열 복사

```java
static void copy() {
    for (int i = 0; i < N; i++) {
        System.arraycopy(copy[i], 0, arr[i], 0, N);
    }
}
```

조합

```java
for (int i = start; i < C; i++) {
    if (!selected[i]) {
        selected[i] = true;
        combination(i + 1, end - 1);  
        // combination에 start를 인자로 줘버려서 중복 탐색 발생
        selected[i] = false;
    }
}
```