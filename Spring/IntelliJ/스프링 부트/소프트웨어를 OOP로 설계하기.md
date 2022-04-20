

# 소프트웨어를 OOP로 설계하기



## 소프트웨어를 OOP 로 설계하는 것

> OOP란?
> 소프트웨어를 기능, 논리보다는 데이터, 객체로 설계하는 것



## 객체 지향 설계 (SOLID)

* SRP : 한 클래스는 하나의 책임만 가져야 한다.
* OCP : 소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다.
* LSP : 프로그램의 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 한다.
* IPS : 특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 낫다.
* DIP : 프로그래머는 추상화에 의존해야지 구체화에 의존하면 안된다.



## oop로 설계하는 방법

정렬을 해주는 프로그램을 만들려 한다.
Main.class

~~~java 
public class Main {
    public static void main(String[] args) {
        Sort<String> sort = new JavaSort<>();

        System.out.println("[result]" + sort.sort(Arrays.asList(args)));
    }
}
~~~

JavaSort.class

~~~java
public class JavaSort<T extends Comparable<T>> {
    public List<T> sort(List<T> list) {
        List<T> output = new ArrayList<>(list);
        Collections.sort(output);
        return output;
    }
}
~~~

BubbleSort.class

~~~java
public class BubbleSort<T extends Comparable<T>> {
    public List<T> sort(List<T> list) {
        List<T> output = new ArrayList<>(list);

        for (int i = output.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (output.get(j).compareTo(output.get(j + 1)) > 0) {
                    T temp = output.get(j);
                    output.set(j, output.get(j + 1));
                    output.set(j + 1, temp);
                }
            }
        }
        return output;
     }
}
~~~



위 처럼 Main 하나 로직을 수행하는 두 클래스를 만들었다.
그러나 이 모습은 oop의 모습이라고 하기 어렵다.

우선 로직들의 인터페이스를 만들어서 로직 구현하는 모습으로 만들자.

Sort.class

~~~java
public interface Sort <T extends Comparable<T>> {
    List<T> sort(List<T> list);
}
~~~

JavaSort.class

~~~java
public class JavaSort<T extends Comparable<T>> implements Sort<T> {
    public List<T> sort(List<T> list) {
        List<T> output = new ArrayList<>(list);
        Collections.sort(output);
        return output;
    }
}
~~~

BubbleSort.class

~~~java
public class BubbleSort<T extends Comparable<T>> implements Sort<T> {
    public List<T> sort(List<T> list) {
        List<T> output = new ArrayList<>(list);

        for (int i = output.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (output.get(j).compareTo(output.get(j + 1)) > 0) {
                    T temp = output.get(j);
                    output.set(j, output.get(j + 1));
                    output.set(j + 1, temp);
                }
            }
        }
        return output;
     }
}
~~~



## 제어 역전



## 의존성 주입

간결합 상태의 모습
정렬 구현체를 바꾸려면, Sort 객체에서 `new BubbleSort<>()`로 바꿔야한다.

이 모습을 바꾸기 위해 의존성을 주입시키려 한다.

~~~java
public class SortService {
    public List<String> doSort(List<String> list) {
      Sort<String> sort = new JavaSort<>();
      
      return sort.sort(list);
    }
}
~~~

---

필드에다 주입하고 싶은 것을 넣는다.

주입하는 테크닉으로 생성자를 이용

SortService.class

~~~java
private final Sort<String> sort;

public SortService(Sort<String> sort) {
        this.sort = sort;
}
~~~

SortService.class

~~~java
public class SortService {

    private final Sort<String> sort;

    public SortService(Sort<String> sort) {
        this.sort = sort;
    }

    public List<String> doSort(List<String> list) {
        return sort.sort(list);
    }
}
~~~

이 모습이 되면 정렬 프로그램은 어떠한 정렬 알고리즘으로 정렬해주는지 확인을 못한다.



그러면 이 service를 사용(테스트) 해보자.

SortService.class

~~~java
class SortServiceTest {
    //사용자는 사용하고 싶은 구현체를 골라서 사용하면 된다.
  	//private SortService sut = new SortService(new JavaSort<String>());
    //private SortService sut = new SortService(new BubbleSort<String>());

    @Test
    void test() {
        // Given

        // When
        List<String> actual = sut.doSort(List.of("3", "2", "1"));

        // Then
        assertEquals(List.of("1", "2", "3"), actual);
    }
}
~~~

정렬 구현체를 바꾸고 싶다. JavaSort에서 BubbleSort로 사용하고 싶다. 간결합 상태에서는 SortService 내에서 객체를 변경하여야 한다.

그러나 위 처럼 의존성을 주입시켜주면, 사용하는 위치에서 사용하고 싶은 구현체를 골라서 사용할 수 있다.

