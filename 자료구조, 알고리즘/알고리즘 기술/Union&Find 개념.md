# Disjoint-Set : Union&Find

* Disjoint-Set이란?

  * 서로 중복되지 않는 부분 집합들

* Union-Find 알고리즘

  * Disjoint Set을 표현할 때 사용하는 트리 구조

  * Union

    * 개별 집합을 하나의 집합으로 합침, 두 트리를 하나의 트리로 만듦

      ![image-20211207163534206](../../md-images/image-20211207163534206.png)

  * Find

    * 여러 노드가 존재할 때, 두 노드가 서로 같은 그래프에 속하는지 판별

    * 각 그룹의 루트 노드를 확인

      <img src="../../md-images/image-20211207163549549.png" alt="image-20211207163549549" style="zoom:50%;" />

      

      

* Union-Find 알고리즘에서 최악의 경우 링크드 리스트 형태를 보임

  * 이 모습을 방지하기 위해, union-by-rank, path compression 기법을 사용함



* union-by-rank 기법

  * 각 트리의 rank를 기억해두고, Union시 
    * 두 트리의 높이가 다르면 높이가 낮은 트리를 높은 트리에 붙임
    * 두 트리의 높이가 같으면 한 쪽 트리 높이를 1증가시키고 다른 쪽 트리를 붙임

* path compression

  * Find시 실행한 노드에서 거쳐간 노드를 루트에 다이렉트로 연결하는 기법

    ~~~java
    static int Find(int v) {
      if (v == unf[v]) return v;
      else return unf[v] = Find(unf[v]); //unf[v] =  이 부분이 압축하는 부분
    }
    ~~~

    



### Graph

* 상위 노드를 저장하는 그래프

~~~java
int[] unf = new int[N+1];
for (int i = 1; i <= N; i++) unf[i] = i; //초기화
~~~



### Find

* 자신이 루트 노드가 아니면, 내 상위 노드들로 올라가면서 루트 노드를 찾아주는 메서드
* path compression 기법으로 나와 내 상위 노드들이 바로 루트 노드를 가리키도록 만든다.

~~~java
static int Find(int v) {
  if (v == unf[v]) return v;
  else return unf[v] = Find(unf[v]);
//else return Find(unf[v]); path compression을 적용 안한 코드
}
~~~



### Union

* a의 루트 노드를 b의 루트 노드로 변경
* 트리를 만들어주는 메서드이다.

~~~java
static void Union(int a, int b) {
  int fa = Find(a);
  int fb = Find(b);
  if (fa != fb) unf[fa] = fb;
}
~~~

