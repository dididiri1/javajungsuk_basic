# 자바 기초 강의 - 5-7강 스트림의 이해와 활용(1)

## Stream API의 이해와 활용
- java 8에 추가된 Stream API를 활용하면 다양한 데이터 소스를 표준화된 방법으로 다룰 수 있다.
- 따라서, Collection F/W를 통해 관리하는 데이터를 처리하기 위해 주로 사용한다.
- Stream API의 활용을 통해 수집된 다양한 데이터를 활용하는데 있어서 간결하고 가독성 있는 처리가 가능함.
- Stream API의 다양한 기능들은 대부분 람다를 필요로 하기 때문에 람다를 이해하고 사용할수 있어야 한다.

``` java
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Ex01 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Lee", "Park", "Kim");

        // 기존
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }

        // 확장 for문
        for (String s : list) {
            System.out.println(s);
        }

        // Stream
        list.stream().forEach(s -> System.out.println(s));
    }
}

``` 

## 활용법

``` java
public class Customer implements Comparable<Customer>{

    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Customer customer) {
        if (this.age > customer.getAge()) {
            return -1;
        } else if (this.age == customer.getAge()) {
            return 0;
        } else {
            return -1;
        }
    }
}

``` 

#### 기존
``` java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ex02 {

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Song", 45));
        customers.add(new Customer("Kim", 33));
        customers.add(new Customer("Park", 21));
        customers.add(new Customer("Lee", 67));
        customers.add(new Customer("Choi", 19));

        List<Customer> list = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getAge() > 30) {
                list.add(customer);
            }
        } // age 30 > 추출

        Collections.sort(list); // age 정렬

        List<String> result = new ArrayList<>();
        for (Customer customer : list) {
            result.add(customer.getName());
        }

        for (String name : result) {
            System.out.println(name);
        }
    }
}
``` 

#### Stream 활용
``` java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ex02 {

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Song", 45));
        customers.add(new Customer("Kim", 33));
        customers.add(new Customer("Park", 21));
        customers.add(new Customer("Lee", 67));
        customers.add(new Customer("Choi", 19));

        List<String> customersNames = customers.stream()
                .filter(customer -> customer.getAge() > 30) // 조건 필터링
                .sorted(Comparator.comparing(Customer::getAge).reversed())  // 내림차순 정렬
                .map(Customer::getName)  // 추출데이터 맵핑
                .collect(Collectors.toList()); // 반환 형태

        for (String name : customersNames) {
            System.out.println(name);
        }
    }
}

``` 

# 자바 기초 강의 - 5-8강 스트림의 이해와 활용(2)

## Stream Interface
- Stream API의 최상의 인터페이스는 BaseStream 인터페이스지만 직접 사용하는 경우는 없다.
- 주로 사용하는 인터페이사는 Stream 인터페이스이며 BaseStream을 상속하는 인터페이스 이다.
- Stream 인터페이스는 여러 메소드들을 정의하고 있으며 많은 메소드들의 파라미터에 람다와 메소드 참조가 필요하다.
- Stream을 구현한 객체의 주요 특징은 불변성이며 Stream을 통해 얻은 결과는 새롭게 생성된 데이터이다.

## Stream 객체 생성 방법 1
- Stream 객체를 생성하는 방법은 Collection 객체를 통한 방법과 스트림 빌더를 통한 방식 두 가지가 있다.
- Collection 인터페이스는 Stream() 메소드를 dafault 메소드로 정의하고 있다.
- 이 메소드는 해당 컬렉션이 가지고 있는 항목들에 대해 스트림 처리가 가능한 Stream 객체를 반환한다.
- **한번 생성한 스트림은 사용 후 다시 사용할 수 없으며** 전체 데이터에 대한 처리가 이루어지면 종료됨.


### Collection 방식
``` java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex03 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Lee", "Kim", "Park", "Hong", "Choi", "Song");

        Stream<String> stream = list.stream(); // Stream 생성
        System.out.println(stream.count()); // Stream 사용
        //stream.forEach(name -> System.out.println(name));
        stream.forEach(System.out::println); // 재사용시 Exception 발생
    }
}


``` 

## Stream 객체 생성 방법 2
- Collection 객체를 통한 생성은 처리할 이미 데이터가 존재하고 이를 처리하기 위한 일반적인 생성 방식이다.
- Stream.Builder를 이용한 Stream 객체의 생성 방식은 스트림 자체적으로 데이터를 생성하고 처리할 수 있다.
- Stream.Biilder 인터페이스는 Consumer 인터페이스를 상속하고 있으며 데이터를 추가하는 accept(), add() 메소드와  
  데이터의 추가 작업을 완료하고 Stream을 반환하는 build() 메소드를 정의하고 있다.

|           메소드            | 기능                         |
|:------------------------:|----------------------------|
|      void accept(T)      | 스트림 빌더에 데이터 추가             |
| Stream.Builder<T> add(T) | 스트림 빌더에 데이터를 추가하고, 스트림 반환  |
|    Stream<T> build()     | 스트림 빌더에 데이터 추가를 종료하고 스트림 반환 |

### Stream.Builder 방식
- 일반적으로 사용 잘안함..
``` java
import java.util.stream.Stream;

public class Ex04 {

    public static void main(String[] args) {
        Stream.Builder<String> builder = Stream.builder();
        builder.accept("Kim");
        builder.accept("Lee");
        builder.accept("Song");
        builder.add("Park");
        builder.add("Lee");

        Stream<String> stream = builder.build();
        stream.forEach(System.out::println);
    }
}

``` 