시간 안에 해결한 문제 : 1,2
추가 해결한 문제 : 

# 문제 요약

### 1번

자료구조(Deque)

### 2번

자료구조(트리)

### 3번

구현

### 4번

# TIL

### 1번

처음엔 정렬을 먼저 생각했던 것 같다.
사전순이라는 단어만 듣고 섣부르게 생각을 했고, 얼마안가 틀렸음을 알게 되었다.
부분집합도 생각을 해보았는데, 조금 더 문제를 읽다보니 데크가 생각났다.
제일 왼쪽 값을 먼저 데크에 넣고, 다음부터 차례대로 값을 비교한다.
현재 값보다 사전순으로 더 앞서면 compareto부분에서 음수를 반환하고, 새로 들어온값을 맨 뒤로 보낸다.
compareto부분이 양수라면 현재 값의 앞에 추가했다.
deque같은 경우 데이터 추가,삭제가 양쪽에서 이뤄져서 그런지 실행시간이 생각보다 길었다.
데크를 사용해야겠다는 생각을 하고 나서는 10분정도 걸렸던 문제다.


### 2번

머리를 조금 굴렸던 문제다.
문제 중 그림에서 원숭이가 가운데 매달려 3가지 경우가 있을 수 있지 않냐는 생각을 잠깐 했는데,
문제에서 시소라고 가정하고 시작해서 문제를 다시 봤다.
루트를 기준으로 왼쪽과 오른쪽의 합이 같아야한다는 대전제가 있다.
이 대전제만 만족한다면 노드의 개수가 중요하지 않았던 것 같다.
가장 큰 관건은 depth(트리의 깊이) 였던 것 같다. 트리의 깊이에 따라 2^n개의 원숭이가 필요했다는 걸 알아냈다.
좌우의 합이 같아야한다는것과, 이진트리임을 명시해줘서 그나마 조금 일찍 알아차린 것 같다.
다른 스터디원의 풀이를 보면 괄호를 통해 깊이를 추적하는 부분은 동일했지만 스택을 사용해서 더 편하게 관리했던 것 같다.
자주 썼던 방법인데 생각해내지 못한게 약간 아쉽기도 하다.
수학적으로 명확하게 증명했다고는 하지 못하겠지만 나름 합리적인 근거로 유추했고, 정답을 받았다.
### 3번
