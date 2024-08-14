08/06 스터디

## 1번 (Q.1487)

- 사람들이 원하는 가격과 배달비를 각각의 사람들이 원하는 가격으로 반복문을 통해 계산해가며 최댓값을 계산

## 2번 (Q.5107)

- HashMap 사용
- <String, String> 형태의 name HashMap과 <String, boolean> 형태의 visited HashMap 생성
- 입력 순서대로 name HashMap에 key, value 값을 put
- for each문을 통해 현재 visited가 false인 key값부터 실행
- 반복문을 돌며 시작 친구가 나타날 때 까지 반복 -> 새로운 x값( value)값이 시작친구가 되면 종료~~
