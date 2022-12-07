<div align=center>

[![Solved.ac프로필](http://mazassumnida.wtf/api/v2/generate_badge?boj=jwj06011)](https://solved.ac/jwj06011)

## 문제
`매일 1문제 [백준 실버 ~ 골드 이상 / 프로그래머스 2 ~ 3 LV]`

## 진행도

|1 주차|2 주차|3 주차|4 주차|5 주차|6 주차|7 주차|8 주차|9 주차|10 주차|
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
|`완료`|`완료`|`완료`|`완료`|`완료`|`완료`|`완료`|`완료`|`완료`|`완료`|
|**11 주차**|**12 주차**|**13 주차**|**14 주차**|**15 주차**|**16 주차**|**17 주차**|**18 주차**|**19 주차**|**20 주차**|
|`완료`|`완료`|`완료`|`완료`|`완료`|`완료`|-|-|-|-|
</div>

---

### ❗️ 엣지 케이스
> 생각하기 힘들거나 상식적이지 않은 입력으로 들어오는 경우
- 입력 값의 크기가 **굉장히 작은 케이스** (대부분의 입력 값이 최소값 언저리인 경우)
- 입력 값의 크기가 **굉장히 큰 케이스** (대부분의 입력 값이 최대값 언저리인 경우)
- 입력 값의 **범위가 넒은** 케이스 (A는 최소값이고 B가 최대값인 경우)
- **음수** 입력이 허용된 경우 음수만 입력받는 케이스
- 리스트를 입력 받을 때 **값이 없거나 하나만 있는** 케이스
- 그래프에서 **사이클(cycle)이 발생**하는 경우
- 길찾기 문제에서 **지그재그**로 움직일 경우
- **부동소수점** 오차

<hr>

### ❗️ 입출력 제한을 보자

#### 1) 입력이 100 이하인 경우
- 완전 탐색
- 백트래킹

#### 2) 입력이 10,000 이하인 경우
> 최대 **O(n2 / n2 log n)** 이내로 끝내야하는 문제
- n*n 2차원 리스트를 모두 순회해야하는 문제가 많음

#### 3) 입력이 1,000,000 이하인 경우
> 최대 **O(n log n)**으로 끝내야하는 문제
- 힙, 우선순위 큐
- 정렬
- 동적 계획법
- 다익스트라 알고리즘

#### 4) 입력이 100,000,000 이하인 경우
> 최대 **O(n)**으로 끝내야하는 문제
- 동적 계획법
- 그리디

#### 그 이상인 경우
> 최대 **O(log n)**으로 끝내야하는 문제가 많음
- 이진탐색

<hr>

### ❗️ 입출력 제한을 보자

> 모든 경로를 "가장 싸게 연결해라"
- 크루스칼 알고리즘

> 실시간으로 정렬이 이루어져야 하는 경우
- 높은 확률로 우선순위 큐 혹은 힙을 사용하는 문제

> 항상 최적의 선택을 해야하는 경우 혹은 "가장 많은 선택을 할 수 있는", "가장 작은/큰" 등의 키워드
- 그리디

> 완전 탐색처럼 시간이 오래걸리면 안되는데 특별한 알고리즘을 사용하는 문제가 아닐거 같을 때
- DP
1) 문제를 따라 먼저 **초기값을 적는다.**
2) 초기값을 포함해 모든 상태값을 적는다.
3) 현재상태를 통해 다음 값을 구할 수 있는지 판단한다.
4) 혹은 **이전 상태들을 통해 현재 값을 구할 수 있는지 판단**한다. 

---
##  알고리즘 사이트
> [백준 온라인 저지](https://www.acmicpc.net/)

> [프로그래머스](https://programmers.co.kr/)

> [SW Expert Academy](https://swexpertacademy.com/main/main.do)


  





