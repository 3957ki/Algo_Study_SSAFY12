# 알고리즘 스터디 9월 19일 (목)

### 1번 The Game of Death (실4)

https://www.acmicpc.net/problem/11558

http://colorscripter.com/s/t5d5RVI

BFS로 최단 거리 구하기 

**다른 BFS와 다른 부분**

각 정점에서 간선은 단 하나를 가지기 때문에 일차원 배열두고 사용가능하다.

배열에서 인덱스는 시작 정점의 값 원솟값은 이동할 정점의 값으로 둔 뒤 BFS 탐색을 진행하였다.

**시간이 오래 걸렸던 부분**

visited 배열에 이동한 거리를 담아서 처리하려고 했지만 해당 부분에서 갑자기 기억이 안나서 헷갈렸음

**개선전 코드**

```java
// 시간: 144ms
while (!q.isEmpty()) {
    Integer v = q.poll();

    if (visited[v]) continue;
    if (v == N - 1) return cnt;
    visited[v] = true;
    q.offer(graph[v]);
    cnt++;
}
```

**개선된 코드**

```java
// 시간: 116 ms
while (!q.isEmpty()) {
    Integer v = q.poll();

    if (v == N - 1) return visited[v];

    int next = graph[v];
    if (visited[next] != -1) continue;
    visited[next] = visited[v] + 1;
    q.offer(next);
}
```

### 2번 Generic Queries (실2)

https://www.acmicpc.net/problem/16713

### 3번 현수막 걸기 (골5)

https://www.acmicpc.net/problem/30459

http://colorscripter.com/s/nzBzztn

조합으로 두개 구하기 + 이분탐색 CustomBound

저번 스터디 블랙프라이데이 문제와 비슷한 문제

다타님의 아이디어가 떠올라서 그대로 구현

말뚝을 두개 박는 부분은 이중 for문을 사용해서 구현하였다.

개선할만한 부분은 custom bound 메서드부분인데 maxIdx의 값을 max로 갱신할 필요 없이 end가 바로 CustomBound의 값이 됨을 알 수 있었다.

**개선전 코드**

```java
// 시간: 312ms
private static int customBound(double target) {
    int start = 0;
    int end = M - 1;
    int maxIdx = -1;

    while (start <= end) {
        int mid = (end + start) / 2;
        if (flags[mid] <= target) {
            start = mid + 1;
            maxIdx = Math.max(maxIdx, mid);
        } else {
            end = mid - 1;
        }
    }
    return maxIdx;
}

```

**개선된 코드**

```java
// 시간: 292ms
private static int customBound(double target) {
    int start = 0;
    int end = M - 1;

    while (start <= end) {
        int mid = (end + start) / 2;
        if (flags[mid] <= target) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }

    return end;  // end가 target 이하의 값 중 최대 값의 인덱스를 가리킴
}
```

### 4번 최대 클리크 구하기 (골3)

https://www.acmicpc.net/problem/13160