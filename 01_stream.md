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